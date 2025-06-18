# PVE Java Client

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.pve-java-client/pve-java-client.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.pve-java-client%22%20AND%20a:%22pve-java-client%22)

一个现代、全面、类型安全的 Proxmox VE Java 客户端库，提供完整的 REST API 覆盖和企业级特性。

## 🚀 核心特性

### 📋 完整的 API 覆盖
- **集群管理**: 集群状态、配置、高可用性、备份任务
- **节点管理**: 节点信息、服务控制、证书管理、存储操作
- **虚拟化**: QEMU 虚拟机和 LXC 容器的完整生命周期管理
- **存储**: 存储池、内容管理、备份和恢复
- **网络**: SDN、防火墙、网络接口配置
- **访问控制**: 用户、组、角色、ACL、双因素认证
- **监控**: 实时数据、RRD 图表、任务状态跟踪

### 🏗️ 现代化架构
- **类型安全**: 完整的 POJO 模型，编译时类型检查
- **流式 API**: 直观的链式调用 `client.nodes().qemu().status().current()`
- **任务监控**: 内置任务状态监控和轮询机制
- **连接池**: 高效的 HTTP 连接管理和复用
- **智能重试**: 基于 Resilience4j 的断路器和重试机制

### 🔐 企业级安全
- **多种认证**: 用户名/密码、API Token 支持
- **会话管理**: 自动 Ticket 获取、缓存和刷新
- **SSL/TLS**: 完整的证书验证和自签名证书支持
- **CSRF 保护**: 自动 CSRF Token 处理

### ⚡ 性能优化
- **连接复用**: 单一 HTTP 客户端实例，避免连接泄漏
- **智能缓存**: 会话和配置信息缓存
- **请求监控**: 内置性能指标和统计信息
- **内存优化**: 高效的 JSON 序列化和响应处理

## 📦 安装

### Maven
```xml
<dependency>
    <groupId>io.github.pve-java-client</groupId>
    <artifactId>pve-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
```gradle
implementation 'io.github.pve-java-client:pve-java-client:1.0.0'
```

## 🏛️ 架构概览

```
┌─────────────────────────────────────────────────────────────┐
│                    Your Application                         │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────────────────┐
│              ProxmoxApiClient (Facade)                     │
├─────────────────────────────────────────────────────────────┤
│  ClusterClient │ NodesClient │ AccessClient │ StorageClient │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────────────────┐
│                ProxmoxApiExecutor                           │
├─────────────────────────────────────────────────────────────┤
│  HTTP 请求执行 │ 错误处理 │ 重试机制 │ 性能监控             │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────────────────┐
│              ProxmoxSessionManager                          │
├─────────────────────────────────────────────────────────────┤
│  认证管理 │ 会话缓存 │ Ticket 自动续期                      │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────────────────┐
│                    OkHttp Client                            │
├─────────────────────────────────────────────────────────────┤
│  连接池 │ SSL/TLS │ 超时控制 │ 压缩                        │
└─────────────────────┬───────────────────────────────────────┘
                      │
                ┌─────▼─────┐
                │ Proxmox VE │
                │  Cluster   │
                └───────────┘
```

## 🚀 快速开始

### 1. 创建客户端

#### 使用用户名/密码认证
```java
import io.github.pve.client.ProxmoxApiClient;
import io.github.pve.client.ProxmoxApiClientFactory;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.ProxmoxClientConfig;

// 基本配置
AuthenticationConfig authConfig = AuthenticationConfig.usernamePassword(
        "root", "your-password", "pam"
);

ProxmoxClientConfig config = ProxmoxClientConfig.builder(
                "my-pve-node",                    // 内部节点标识
                "https://your-pve-host:8006",     // PVE API URL
                authConfig
        )
        .trustSelfSignedCerts(true)           // 开发环境可用
        .build();

ProxmoxApiClient client = ProxmoxApiClientFactory.createClient(config);
```

#### 使用 API Token 认证
```java
AuthenticationConfig authConfig = AuthenticationConfig.apiToken(
        "root@pam!mytoken",
        "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"
);

ProxmoxClientConfig config = ProxmoxClientConfig.builder(
                "my-pve-node",
                "https://your-pve-host:8006",
                authConfig
        )
        .build();

ProxmoxApiClient client = ProxmoxApiClientFactory.createClient(config);
```

### 2. 高级配置

```java
import io.github.pve.client.config.*;
import java.time.Duration;

// HTTP 配置
HttpConfig httpConfig = HttpConfig.builder()
        .connectTimeout(Duration.ofSeconds(30))
        .readTimeout(Duration.ofMinutes(5))
        .writeTimeout(Duration.ofMinutes(2))
        .maxIdleConnections(5)
        .keepAliveDuration(Duration.ofMinutes(5))
        .build();

// 缓存配置
CacheConfig cacheConfig = CacheConfig.builder()
        .sessionCacheSize(100)
        .sessionTtl(Duration.ofHours(2))
        .build();

// 韧性配置
ResilienceConfig resilienceConfig = ResilienceConfig.builder()
        .maxRetries(3)
        .retryDelay(Duration.ofSeconds(1))
        .circuitBreakerFailureThreshold(5)
        .circuitBreakerTimeout(Duration.ofMinutes(1))
        .rateLimitRequestsPerSecond(10)
        .build();

ProxmoxClientConfig config = ProxmoxClientConfig.builder(
                "my-pve-node",
                "https://your-pve-host:8006",
                authConfig
        )
        .httpConfig(httpConfig)
        .cacheConfig(cacheConfig)
        .resilienceConfig(resilienceConfig)
        .build();
```

## 💡 使用示例

### 集群管理

```java
// 获取集群状态
List<GetStatusResponse> clusterStatus = client.cluster().status().getStatus();
clusterStatus.forEach(node ->
        System.out.println("Node: " + node.getName() + ", Online: " + node.getOnline())
        );

// 获取集群资源
ResourcesResponse resources = client.cluster().resources().resources();
System.out.println("Total Resources: " + resources.getData().size());

// 创建备份任务
CreateJobRequest backupJob = CreateJobRequest.builder()
        .id("backup-daily")
        .schedule("0 2 * * *")  // 每天凌晨2点
        .vmid("100,101,102")
        .storage("backup-storage")
        .mode("snapshot")
        .enabled(true)
        .build();

client.cluster().backup().createJob(backupJob);
```

### 节点管理

```java
// 列出所有节点
IndexResponse nodes = client.nodes().index();
nodes.getData().forEach(node ->
        System.out.println("Node: " + node.getNode() + ", Status: " + node.getStatus())
        );

// 获取节点状态
String nodeName = "pve";
StatusResponse nodeStatus = client.nodes().status(nodeName).status();
System.out.println("CPU Usage: " + nodeStatus.getCpu());
        System.out.println("Memory Usage: " + nodeStatus.getMemory());

// 获取节点服务
List<Object> services = client.nodes().services(nodeName).index();
System.out.println("Services count: " + services.size());
```

### 虚拟机管理

```java
// 列出虚拟机
VmlistResponse vmList = client.nodes().qemu(nodeName).vmlist();
vmList.getData().forEach(vm ->
        System.out.println("VM " + vm.getVmid() + ": " + vm.getName() + " (" + vm.getStatus() + ")")
        );

// 创建虚拟机
CreateVmRequest createVm = CreateVmRequest.builder()
        .vmid(999)
        .name("test-vm")
        .cores(2)
        .memory(2048L)
        .scsi0("local-lvm:32")
        .net0("virtio,bridge=vmbr0")
        .ostype("l26")
        .build();

String taskId = client.nodes().qemu(nodeName).createVm(createVm);
System.out.println("VM creation task: " + taskId);

// 监控任务状态
ReadTaskStatusResponse taskStatus;
do {
        Thread.sleep(2000);
taskStatus = client.nodes().tasks(nodeName).status(taskId).readTaskStatus();
    System.out.println("Task status: " + taskStatus.getStatus());
        } while (!"stopped".equals(taskStatus.getStatus()));

// 启动虚拟机
VmStartRequest startRequest = VmStartRequest.builder().build();
String startTaskId = client.nodes().qemu(nodeName).status(999).start().vmStart(startRequest);
System.out.println("VM start task: " + startTaskId);

// 获取虚拟机状态
VmStatusResponse vmStatus = client.nodes().qemu(nodeName).status(999).current().vmStatus();
System.out.println("VM Status: " + vmStatus.getStatus());
        System.out.println("CPU Usage: " + vmStatus.getCpu());
        System.out.println("Memory: " + vmStatus.getMem() + "/" + vmStatus.getMaxmem());
```

### 容器管理

```java
// 列出容器
VmlistResponse containerList = client.nodes().lxc(nodeName).vmlist();
containerList.getData().forEach(ct ->
        System.out.println("CT " + ct.getVmid() + ": " + ct.getName() + " (" + ct.getStatus() + ")")
        );

// 创建容器
CreateVmRequest createCt = CreateVmRequest.builder()
        .vmid(888)
        .hostname("test-container")
        .memory(512L)
        .rootfs("local-lvm:8")
        .net0("name=eth0,bridge=vmbr0,ip=dhcp")
        .ostemplate("local:vztmpl/ubuntu-20.04-standard_20.04-1_amd64.tar.gz")
        .build();

String ctTaskId = client.nodes().lxc(nodeName).createVm(createCt);
System.out.println("Container creation task: " + ctTaskId);
```

### 存储管理

```java
// 列出存储
IndexResponse storageList = client.nodes().storage(nodeName).index();
storageList.getData().forEach(storage ->
        System.out.println("Storage: " + storage.getStorage() +
        ", Type: " + storage.getType() +
        ", Available: " + storage.getAvail())
        );

// 获取存储内容
IndexResponse content = client.nodes().storage(nodeName).content("local").index();
content.getData().forEach(item ->
        System.out.println("Content: " + item.getVolid() + ", Size: " + item.getSize())
        );

// 上传 ISO 文件
UploadRequest uploadRequest = UploadRequest.builder()
        .content("iso")
        .filename("ubuntu-20.04.iso")
        .build();
// 注意：实际文件上传需要使用 multipart/form-data
```

### 访问控制管理

```java
// 列出用户
IndexResponse users = client.access().users().index();
users.getData().forEach(user ->
        System.out.println("User: " + user.getUserid() + ", Enabled: " + user.getEnabled())
        );

// 创建用户
CreateUserRequest newUser = CreateUserRequest.builder()
        .userid("testuser@pam")
        .password("SecurePassword123!")
        .email("test@example.com")
        .firstname("Test")
        .lastname("User")
        .groups("users")
        .build();

client.access().users().createUser(newUser);

// 设置 ACL 权限
UpdateAclRequest aclRequest = UpdateAclRequest.builder()
        .path("/vms/100")
        .users("testuser@pam")
        .roles("PVEVMUser")
        .build();

client.access().acl().updateAcl(aclRequest);
```

### 监控和统计

```java
// 获取性能统计
Map<String, Long> stats = ProxmoxApiExecutor.getStatistics();
System.out.println("Total Requests: " + stats.get("totalRequests"));
        System.out.println("Successful Requests: " + stats.get("successfulRequests"));
        System.out.println("Failed Requests: " + stats.get("failedRequests"));

// 获取 RRD 数据
        client.nodes().rrd(nodeName).nodeRrd("cpu", "hour");
```

## 🔧 错误处理

```java
import io.github.pve.client.exception.*;

try {
VmStatusResponse status = client.nodes().qemu(nodeName).status(999).current().vmStatus();
    System.out.println("VM Status: " + status.getStatus());
        } catch (ProxmoxAuthException e) {
        System.err.println("Authentication failed: " + e.getMessage());
        // 重新认证或检查凭据
        } catch (ProxmoxApiException e) {
        System.err.println("API error: " + e.getMessage());
        System.err.println("HTTP Status: " + e.getStatusCode());
        } catch (ProxmoxException e) {
        System.err.println("General Proxmox error: " + e.getMessage());
        }
```

## 🔄 任务状态监控

```java
// 手动轮询任务状态
String taskId = client.nodes().qemu(nodeName).createVm(createVmRequest);
ReadTaskStatusResponse taskStatus;
do {
        Thread.sleep(2000);
taskStatus = client.nodes().tasks(nodeName).status(taskId).readTaskStatus();
    System.out.println("Progress: " + taskStatus.getProgress() + "%");
        } while (!"stopped".equals(taskStatus.getStatus()));

        if ("OK".equals(taskStatus.getExitStatus())) {
        System.out.println("Task completed successfully");
} else {
        System.err.println("Task failed: " + taskStatus.getExitStatus());
        }
```

## 📊 最佳实践

### 1. 连接管理
```java
// ✅ 推荐：复用客户端实例
public class ProxmoxService {
    private final ProxmoxApiClient client;

    public ProxmoxService() {
        this.client = ProxmoxApiClientFactory.createClient(config);
    }

    // 在整个应用生命周期中复用这个客户端
}

// ❌ 避免：频繁创建客户端
// 每次调用都创建新客户端会导致连接泄漏
```

### 2. 异常处理
```java
// ✅ 推荐：分层异常处理
public void manageVM(String nodeName, int vmid) {
    try {
        VmStatusResponse status = client.nodes().qemu(nodeName).status(vmid).current().vmStatus();
        // 处理成功情况
    } catch (ProxmoxAuthException e) {
        // 认证相关错误
        handleAuthError(e);
    } catch (ProxmoxApiException e) {
        // API 相关错误
        handleApiError(e);
    } catch (Exception e) {
        // 其他错误
        handleGeneralError(e);
    }
}
```

### 3. 配置管理
```java
// ✅ 推荐：外部化配置
@ConfigurationProperties("proxmox")
public class ProxmoxProperties {
    private String apiUrl;
    private String username;
    private String password;
    private boolean trustSelfSignedCerts;
    // getters and setters
}
```

### 4. 日志记录
```java
// 在 logback.xml 或 application.properties 中配置
// logging.level.io.github.pve.client=DEBUG  # 开发环境
// logging.level.io.github.pve.client=INFO   # 生产环境
```

## 🧪 测试

### 核心功能测试框架

项目提供了全面的PVE核心功能测试，涵盖虚拟化管理的各个方面：

#### 🎯 主要测试模块

| 测试类 | 功能描述 | 核心特性 |
|--------|----------|----------|
| **VirtualMachineApiTest** | KVM虚拟机管理 | 创建、配置、状态管理、快照、克隆 |
| **ContainerApiTest** | LXC容器管理 | 创建、配置、状态管理、快照、模板 |
| **BackupApiTest** | 备份和恢复 | 手动备份、定时任务、恢复、清理策略 |
| **StorageManagementApiTest** | 存储管理 | 磁盘操作、LVM/ZFS、内容管理 |

#### 🔧 基础设施测试

- **VersionApiTest** - 版本信息获取
- **StorageApiTest** - 存储配置管理
- **PoolsApiTest** - 资源池管理
- **AccessApiTest** - 权限控制测试
- **NodesApiTest** - 节点状态管理
- **ClusterApiTest** - 集群监控

### 测试特性

- ✅ **全面覆盖**: 涵盖PVE核心功能的完整测试
- ✅ **自动清理**: 测试完成后自动清理创建的资源
- ✅ **错误容忍**: 智能处理权限和环境问题
- ✅ **详细日志**: 提供详细的操作日志和状态信息
- ✅ **安全隔离**: 使用专用ID范围避免与生产环境冲突

### 运行测试

```bash
# 运行所有测试
mvn test

# 运行核心功能测试
mvn test -Dtest=VirtualMachineApiTest
mvn test -Dtest=ContainerApiTest
mvn test -Dtest=BackupApiTest

# 运行特定测试方法
mvn test -Dtest=VirtualMachineApiTest#testCreateSimpleVM
```

### 测试配置

```java
// 配置测试环境
public class TestConfig {
    public static final String PVE_HOST = "your-pve-host";
    public static final String USERNAME = "root@pam";
    public static final String PASSWORD = "your-password";
    public static final String TEST_NODE_NAME = "your-node";
}
```

详细的测试说明请参考 [测试文档](src/test/README.md)。

## 📋 系统要求

- **Java**: 17 或更高版本
- **Proxmox VE**: 6.x, 7.x, 8.x
- **依赖**: OkHttp 4.12+, Jackson 2.15+, Resilience4j 2.2+

## 🤝 贡献

欢迎贡献代码！请遵循以下步骤：

1. Fork 项目
2. 创建特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'Add amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 开启 Pull Request

## 📄 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 🙋‍♂️ 支持

- **文档**: [Wiki](https://github.com/xiao-rao/pve-java-client/wiki)
- **问题反馈**: [Issues](https://github.com/xiao-rao/pve-java-client/issues)
- **讨论**: [Discussions](https://github.com/xiao-rao/pve-java-client/discussions)

## 🏆 致谢

感谢 Proxmox VE 团队提供优秀的虚拟化平台，以及所有为开源社区做出贡献的开发者们。