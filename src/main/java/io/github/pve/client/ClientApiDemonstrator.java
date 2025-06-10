package io.github.pve.client;



import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.ProxmoxClientConfig;
import io.github.pve.client.exception.ProxmoxException;
import io.github.pve.client.model.version.Version;
import io.github.pve.client.model.access.AuthDomain;
import io.github.pve.client.model.access.Group;
import io.github.pve.client.model.access.options.GroupCreationOrUpdateOptions;
import io.github.pve.client.model.access.Role;
import io.github.pve.client.model.access.User;
import io.github.pve.client.model.access.options.UserCreationOrUpdateOptions;
import io.github.pve.client.model.pool.Pool;
import io.github.pve.client.model.storage.StorageSummary;

import java.util.List;
import java.util.UUID;

/**
 * Proxmox API 客户端功能演示.
 *
 * <p><b>重要:</b> 在运行前，请务必修改下面的 <b>PVE 连接配置</b> 部分，
 * 填入您自己的 Proxmox VE 服务器的真实信息。</p>
 *
 * <p>这个类提供了一个简单的 {@code main} 方法来演示如何使用客户端
 * 与 Proxmox VE API 进行交互，覆盖了 access, pools, storage, 和 version 模块。</p>
 */
public class ClientApiDemonstrator {

    // ===============================================================
    // =================== PVE 连接配置 (请在此处修改) ==================
    // ===============================================================
    private static final String PVE_API_URL = "https://172.16.1.33:8006";
    private static final String PVE_NODE_ID = "pve-java-client-node"; // 客户端内部使用的ID,可任意
    private static final String PVE_REALM = "pam"; // 认证领域
    private static final String ADMIN_USER = "root";
    private static final String ADMIN_PASSWORD = "Aq1231998@@"; // 您的管理员密码
    private static final boolean TRUST_SELF_SIGNED_CERTS = true; // 如果使用自签名证书,设为true
    // ===============================================================
    // ========================== 配置结束 ===========================
    // ===============================================================

    private static ProxmoxApiClient apiClient;

    public static void main(String[] args) {
        System.out.println("--- Proxmox VE Java Client Demonstration ---");

        if (PVE_API_URL.contains("YOUR_PVE_HOST")) {
            System.err.println("错误: 请在 ClientApiDemonstrator.java 文件中修改 PVE 连接配置！");
            return;
        }

        try {
            // 1. 初始化客户端
            initializeApiClient();

            // 2. 运行各个模块的演示
            runVersionDemo();
            runStorageDemo();
            runPoolsDemo();
            runAccessDemo();

            System.out.println("\n--- 所有演示成功完成！ ---");

        } catch (ProxmoxException e) {
            System.err.println("\n!!! 操作失败 !!!");
            System.err.println("错误类型: " + e.getClass().getSimpleName());
            System.err.println("错误信息: " + e.getMessage());
            // 打印堆栈信息以便于调试
            e.printStackTrace();
        }
    }

    private static void initializeApiClient() {
        System.out.println("\n[正在初始化 API 客户端...]");
        AuthenticationConfig authConfig = AuthenticationConfig.usernamePassword(
                ADMIN_USER, ADMIN_PASSWORD, PVE_REALM
        );

        ProxmoxClientConfig config = ProxmoxClientConfig.builder(
                        PVE_NODE_ID,
                        PVE_API_URL,
                        authConfig
                )
                .trustSelfSignedCerts(TRUST_SELF_SIGNED_CERTS)
                .build();

        apiClient = ProxmoxApiClientFactory.createClient(config);
        System.out.println("客户端初始化成功！");
    }

    private static void runVersionDemo() {
        System.out.println("\n========== [Version 模块演示] ==========");
        Version version = apiClient.version().get();
        System.out.println("获取到Proxmox VE版本信息:");
        System.out.println("  - Version: " + version.getVersion());
        System.out.println("  - Repo ID: " + version.getRepoId());
        System.out.println("  - Release: " + version.getRelease());
    }

    private static void runStorageDemo() {
        System.out.println("\n========== [Storage 模块演示] ==========");
        List<StorageSummary> storages = apiClient.storage().list();
        System.out.println("获取到 " + storages.size() + " 个存储:");
        for (StorageSummary storage : storages) {
            // 在比较之前检查是否为null
            Boolean isEnabled = storage.getEnabled() != null && storage.getEnabled() == 1;
            System.out.printf("  - [%-15s] Type: %-10s | Content: %-25s | Enabled: %s%n",
                    storage.getStorage(),
                    storage.getType(),
                    storage.getContent(),
                    isEnabled); // 使用修正后的安全值
        }
    }

    private static void runPoolsDemo() {
        System.out.println("\n========== [Pools 模块演示] ==========");
        String testPoolId = "test-pool-" + UUID.randomUUID().toString().substring(0, 8);

        try {
            // 1. 列出现有池
            List<Pool> initialPools = apiClient.pools().list();
            System.out.println("当前共有 " + initialPools.size() + " 个资源池。");

            // 2. 创建新池
            System.out.println("尝试创建新资源池: " + testPoolId);
            apiClient.pools().create(testPoolId, "由Java客户端创建的测试池");
            System.out.println("  -> 创建成功！");

            // 3. 获取并验证新池
            System.out.println("获取并验证新创建的池...");
            Pool createdPool = apiClient.pools().get(testPoolId);
            if (testPoolId.equals(createdPool.getPoolId())) {
                System.out.println("  -> 验证成功！获取到的池信息: " + createdPool);
            } else {
                throw new IllegalStateException("验证失败：获取到的池ID与创建的池ID不符！");
            }

        } finally {
            // 4. 清理 (无论成功与否都尝试删除)
            System.out.println("清理测试资源池: " + testPoolId);
            try {
                apiClient.pools().delete(testPoolId);
                System.out.println("  -> 清理成功！");
            } catch (ProxmoxException e) {
                System.err.println("清理测试池失败: " + e.getMessage());
            }
        }
    }

    private static void runAccessDemo() {
        System.out.println("\n========== [Access 模块演示] ==========");
        String testUserId = "testuser-" + UUID.randomUUID().toString().substring(0, 8) + "@" + PVE_REALM;
        String testGroupId = "test-group-" + UUID.randomUUID().toString().substring(0, 8);
        String testRoleId = "TestRole" + UUID.randomUUID().toString().substring(0, 4);

        try {
            // --- 用户演示 ---
            System.out.println("\n--- [用户管理演示] ---");
            System.out.println("尝试创建新用户: " + testUserId);
            UserCreationOrUpdateOptions userOptions = UserCreationOrUpdateOptions.builder()
//                    .password("TestPassword123!")
                    .email("test@example.com")
                    .comment("由Java客户端创建的测试用户")
                    .build();
            apiClient.access().users().create(testUserId, userOptions);
            System.out.println("  -> 用户创建成功！");
            User createdUser = apiClient.access().users().get(testUserId);
            System.out.println("  -> 获取到用户信息: " + createdUser);

            // --- 组演示 ---
            System.out.println("\n--- [组管理演示] ---");
            System.out.println("尝试创建新组: " + testGroupId);
            apiClient.access().groups().create(testGroupId, GroupCreationOrUpdateOptions.builder().comment("测试组").build());
            System.out.println("  -> 组创建成功！");
            Group createdGroup = apiClient.access().groups().get(testGroupId);
            System.out.println("  -> 获取到组信息: " + createdGroup);

            // --- 角色演示 ---
            System.out.println("\n--- [角色管理演示] ---");
            List<Role> roles = apiClient.access().roles().list();
            System.out.println("获取到 " + roles.size() + " 个角色。示例角色 'PVEVMUser':");
            Role vmUserRole = apiClient.access().roles().get("PVEVMUser");
            System.out.println("  -> 角色详情: " + vmUserRole);

            // --- 认证领域演示 ---
            System.out.println("\n--- [认证领域演示] ---");
            List<AuthDomain> domains = apiClient.access().domains().list();
            System.out.println("获取到 " + domains.size() + " 个认证领域:");
            domains.forEach(d -> System.out.println("  -> " + d));

        } finally {
            // --- 清理所有测试资源 ---
            System.out.println("\n--- [清理Access模块测试资源] ---");
            // 清理用户
            try {
                System.out.println("清理测试用户: " + testUserId);
                apiClient.access().users().delete(testUserId);
                System.out.println("  -> 用户清理成功！");
            } catch (Exception e) {
                System.err.println("清理用户失败: " + e.getMessage());
            }
            // 清理组
            try {
                System.out.println("清理测试组: " + testGroupId);
                apiClient.access().groups().delete(testGroupId);
                System.out.println("  -> 组清理成功！");
            } catch (Exception e) {
                System.err.println("清理组失败: " + e.getMessage());
            }
        }
    }
}
