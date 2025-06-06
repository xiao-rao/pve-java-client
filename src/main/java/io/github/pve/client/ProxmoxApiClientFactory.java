package io.github.pve.client;

import io.github.pve.client.config.ProxmoxClientConfig;
//import io.github.pve.client.exception.ProxmoxApiException;
//import io.github.pve.client.config.AuthenticationConfig;
//import io.github.pve.client.exception.ProxmoxAuthException;
//import io.github.pve.client.model.node.NodeStatus;
//import io.github.pve.client.model.vm.VirtualMachineSummary;
import okhttp3.OkHttpClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Proxmox API客户端工厂
 * 用于构建ProxmoxApiClient实例。
 */
public class ProxmoxApiClientFactory {
    private static final OkHttpClient SHARED_DEFAULT_OKHTTP_CLIENT_TEMPLATE = new OkHttpClient.Builder().build();

    /**
     * 使用给定的配置创建一个新的ProxmoxApiClient实例。
     *
     * @param config Proxmox客户端配置
     * @return ProxmoxApiClient实例
     */
    public static ProxmoxApiClient createClient(ProxmoxClientConfig config) {
        return new ProxmoxApiClient(config, SHARED_DEFAULT_OKHTTP_CLIENT_TEMPLATE);
    }

    /**
     * 使用给定的配置和自定义的OkHttpClient模板创建一个新的ProxmoxApiClient实例。
     *
     * @param config Proxmox客户端配置
     * @param okHttpClientTemplate 用于构建实际OkHttpClient的模板。超时等会从ProxmoxClientConfig中覆盖。
     * @return ProxmoxApiClient实例
     */
    public static ProxmoxApiClient createClient(ProxmoxClientConfig config, OkHttpClient okHttpClientTemplate) {
        if (okHttpClientTemplate == null) {
            okHttpClientTemplate = SHARED_DEFAULT_OKHTTP_CLIENT_TEMPLATE;
        }
        return new ProxmoxApiClient(config, okHttpClientTemplate);
    }

    // --- 示例Main方法 (用于演示，实际使用中应移除或放在测试类中) ---
//    public static void main(String[] args) {
//        final Logger MAIN_LOGGER = LoggerFactory.getLogger("ProxmoxApiClientFactoryDemo");
//        // === 配置: 请根据您的Proxmox VE环境修改以下参数 ===
//        String pveApiUrl = "https://YOUR_PVE_HOST_OR_IP:8006"; // 基础URL，/api2/json会自动添加
//        String pveNodeId = "pve1"; // 任意标识符，用于缓存key等
//        String pveClusterNodeName = "YOUR_PVE_NODE_NAME"; // PVE集群中节点的实际名称
//        boolean trustSelfSigned = true;
//
//        // --- 认证方式1: 用户名/密码 ---
//        AuthenticationConfig userPassAuthConfig = AuthenticationConfig.usernamePassword(
//                "root", "YOUR_PASSWORD", "pam" // 使用您的用户名、密码和领域
//        );
//
//        // --- 认证方式2: API Token ---
//        // AuthenticationConfig apiTokenAuthConfig = AuthenticationConfig.apiToken(
//        //         "user@pam!yourTokenId", "YOUR_API_TOKEN_SECRET"
//        // );
//
//        // 选择一种认证配置
//        AuthenticationConfig currentAuthConfig = userPassAuthConfig; // 或 apiTokenAuthConfig
//
//        ProxmoxClientConfig clientConfig = ProxmoxClientConfig.builder(pveNodeId, pveApiUrl, currentAuthConfig)
//                .trustSelfSignedCerts(trustSelfSigned)
//                // .httpConfig(...) // 可选，自定义HTTP超时等
//                // .cacheConfig(...) // 可选，自定义缓存行为
//                .build();
//
//        ProxmoxApiClient apiClient = ProxmoxApiClientFactory.createClient(clientConfig);
//
//        try {
//            // apiClient.connect(); // 可选的预热连接
//            MAIN_LOGGER.info("Attempting to get status for PVE cluster node: {}", pveClusterNodeName);
//
//            // 使用NodeResourceClient
//            NodeStatus nodeStatus = apiClient.nodes().getNodeStatus(pveClusterNodeName);
//            MAIN_LOGGER.info("Status of node {}: PVE Version={}, CPU Usage={}%",
//                    pveClusterNodeName, nodeStatus.pveversion, String.format("%.2f", nodeStatus.cpu * 100));
//
//            MAIN_LOGGER.info("Listing VMs on node {}:", pveClusterNodeName);
//            java.util.List<VirtualMachineSummary> vms = apiClient.nodes().listVirtualMachines(pveClusterNodeName);
//            if (vms.isEmpty()) {
//                MAIN_LOGGER.info("No VMs found.");
//            } else {
//                vms.forEach(vm -> MAIN_LOGGER.info(" - VM ID: {}, Name: {}, Status: {}", vm.vmid, vm.name, vm.status));
//            }
//
//            // 示例：如果实现了VirtualMachineResourceClient并添加了相关方法
//            // String newVmUpid = apiClient.virtualMachines().createVirtualMachine(pveClusterNodeName, new VMCreationOptions(...));
//            // apiClient.virtualMachines().waitForTaskCompletion(pveClusterNodeName, newVmUpid, 120, 2000);
//            // MAIN_LOGGER.info("New VM created (task completed).");
//
//
//        } catch (ProxmoxAuthException authEx) {
//            MAIN_LOGGER.error("PVE Authentication Error: {}", authEx.getMessage(), authEx);
//        } catch (ProxmoxApiException apiEx) {
//            MAIN_LOGGER.error("PVE API Error (Node: {}, Endpoint: {}): {} (Status: {})",
//                    apiEx.getPveNodeId(), apiEx.getApiEndpoint(), apiEx.getMessage(), apiEx.getStatusCode());
//            if (apiEx.getErrorResponse() != null) {
//                MAIN_LOGGER.error("Error Response Body: {}", apiEx.getErrorResponse());
//            }
//        } catch (Exception e) {
//            MAIN_LOGGER.error("An unexpected error occurred: {}", e.getMessage(), e);
//        }
//    }
}
