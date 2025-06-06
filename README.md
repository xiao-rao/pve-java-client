# PVE Java Client

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.proxmox-java-client/proxmox-ve-java-client.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.proxmox-java-client%22%20AND%20a:%22proxmox-ve-java-client%22)

一个现代、全面、流式API风格的 Proxmox VE Java 客户端库。

这是一个为 Proxmox Virtual Environment (PVE) 设计的功能强大的Java客户端，它封装了PVE的RESTful API，提供了一套类型安全、易于使用的Java接口。无论您是想构建自己的云管理平台，还是想自动化您的PVE运维任务，这个库都能为您提供坚实的基础。

## 核心特性

- **全面的API覆盖**: 支持集群、节点、虚拟机(QEMU)、存储、网络、访问控制(用户/组/角色/ACL)、资源池、快照和备份等绝大部分常用API。
- **现代化的设计**:
    - **流式API**: 通过 `apiClient.nodes().list()` 这样的链式调用，让代码更具可读性。
    - **健壮的会话管理**: 内置对用户名/密码和API Token两种认证方式的支持，并自动处理会话（Ticket）和CSRF Token的获取、缓存与刷新。
    - **异步任务处理**: 提供便捷的 `waitForTaskCompletion` 方法，优雅地处理Proxmox的异步任务。
- **易于使用和配置**:
    - **灵活的配置**: 通过Builder模式轻松配置连接、认证和超时等参数。
    - **清晰的异常处理**: 定义了层次分明的异常（`ProxmoxAuthException`, `ProxmoxApiException`），方便捕获和处理错误。
- **类型安全**: 大量使用泛型和强类型的POJO模型，减少运行时错误。
- **独立性**: 作为一个独立的库，无任何重量级框架依赖，可以轻松集成到任何Java项目中。

## 架构图

客户端采用分层设计，职责清晰，易于扩展。

```mermaid
graph TD
    subgraph "您的应用程序"
        A[业务逻辑 / Web服务]
    end

    subgraph "Proxmox VE Java Client Library"
        direction LR
        subgraph "公共API层 (Public API Layer)"
            B[ProxmoxApiClientFactory] --> C{ProxmoxApiClient};
            C --> D[ClusterResourceClient];
            C --> E[NodeResourceClient];
            C --> F[VirtualMachineResourceClient];
            C --> G[...]
        end
        
        subgraph "核心引擎 (Internal Core Engine)"
            K[ProxmoxApiExecutor] -- 使用 --> L[ProxmoxSessionManager];
            L -- 管理 --> M[ProxmoxSessionCache];
            L -- 认证 --> N[AuthenticationProvider];
            K -- 发送HTTP请求 --> O[OkHttp];
        end
        
        D & E & F & G -- 调用 --> K;
    end
    
    A -- 创建 --> B;
    O -- HTTPS --> P((Proxmox VE Cluster));

    style A fill:#cde4ff,stroke:#6495ED,stroke-width:2px
    style C fill:#d5f5e3,stroke:#2ECC71,stroke-width:2px
    style K fill:#fff5cc,stroke:#ffc300,stroke-width:1.5px
    style L fill:#fff5cc,stroke:#ffc300,stroke-width:1.5px
````

- **ProxmoxApiClientFactory**: 客户端的创建入口。
- **ProxmoxApiClient**: 客户端的主门面，聚合了所有资源客户端。
- **Resource Clients**: 每个客户端（如`VirtualMachineResourceClient`）负责一类特定的PVE资源。
- **ProxmoxApiExecutor**: 核心的HTTP请求执行器，负责发送请求和解析响应。
- **ProxmoxSessionManager**: 负责认证和会话管理，是客户端保持登录状态的关键。
- **AuthenticationProvider**: 支持多种认证方式的策略接口。
- **OkHttp**: 底层的HTTP通信库。

## 安装

将以下依赖添加到您的 `pom.xml` 文件中：

```xml
<dependency>
    <groupId>io.github.proxmox-java-client</groupId>
    <artifactId>proxmox-ve-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 快速入门

### 1\. 配置并创建客户端

```java
import io.github.proxmox.ve.client.ProxmoxApiClient;
import io.github.proxmox.ve.client.ProxmoxApiClientFactory;
import io.github.proxmox.ve.client.config.AuthenticationConfig;
import io.github.proxmox.ve.client.config.ProxmoxClientConfig;

// 使用用户名/密码认证
AuthenticationConfig authConfig = AuthenticationConfig.usernamePassword(
    "root", "YourAdminPassword", "pam"
);

// 或者使用API Token认证
// AuthenticationConfig authConfig = AuthenticationConfig.apiToken(
//     "root@pam!mytoken", "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"
// );

ProxmoxClientConfig config = ProxmoxClientConfig.builder(
        "pve-node-1", // 客户端内部使用的节点ID
        "https://your-pve-host:8006", // PVE API URL
        authConfig
    )
    .trustSelfSignedCerts(true) // 仅限开发环境！
    .build();

ProxmoxApiClient apiClient = ProxmoxApiClientFactory.createClient(config);
```

### 2\. 调用API

#### 获取集群状态

```java
import io.github.proxmox.ve.client.model.cluster.ClusterStatus;
import java.util.List;

List<ClusterStatus> status = apiClient.cluster().getStatus();
status.forEach(s -> System.out.println("Node: " + s.getName() + ", Online: " + s.getOnline()));
```

#### 列出虚拟机

```java
import io.github.proxmox.ve.client.model.vm.VirtualMachineSummary;

// 假设PVE集群中有一个名为 'pve' 的节点
String pveNodeName = "pve";
List<VirtualMachineSummary> vms = apiClient.nodes().listVirtualMachines(pveNodeName);
vms.forEach(vm -> System.out.println(
    "VM ID: " + vm.getVmid() + ", Name: " + vm.getName() + ", Status: " + vm.getStatus()
));
```

#### 创建虚拟机

```java
import io.github.proxmox.ve.client.model.vm.VMCreationOptions;

String pveNodeName = "pve";
VMCreationOptions options = VMCreationOptions.builder()
        .vmid(1001)
        .name("my-new-vm")
        .cores(2)
        .memory(2048L) // 2048 MiB
        .scsi0("local-lvm:10") // 在 'local-lvm' 存储上创建10G磁盘
        .ide2("local:iso/ubuntu-server.iso,media=cdrom") // 挂载ISO
        .net0("virtio,bridge=vmbr0")
        .build();

// 创建是一个异步操作，会返回一个任务ID
String taskId = apiClient.virtualMachines().create(pveNodeName, options);
System.out.println("VM creation task started: " + taskId);

// 等待任务完成
apiClient.virtualMachines().waitForTaskCompletion(taskId, 180, 2000); // 超时180秒，每2秒轮询一次
System.out.println("VM 1001 created successfully!");
```

#### 启动和停止虚拟机

```java
String pveNodeName = "pve";
int vmid = 1001;

// 启动
String startTaskId = apiClient.virtualMachines().start(pveNodeName, vmid);
apiClient.virtualMachines().waitForTaskCompletion(startTaskId, 60, 1000);
System.out.println("VM " + vmid + " started.");

// 停止
String stopTaskId = apiClient.virtualMachines().stop(pveNodeName, vmid, null);
apiClient.virtualMachines().waitForTaskCompletion(stopTaskId, 60, 1000);
System.out.println("VM " + vmid + " stopped.");
```

## 许可证

该项目根据 [Apache License 2.0](https://www.google.com/search?q=LICENSE) 授权。