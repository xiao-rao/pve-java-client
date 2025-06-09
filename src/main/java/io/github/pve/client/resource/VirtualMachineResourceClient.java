package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.model.vm.*;
import io.github.pve.client.model.vm.options.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 虚拟机 (QEMU) 资源客户端
 * 提供对Proxmox中虚拟机的创建、读取、更新和删除 (CRUD) 操作，以及快照和备份管理。
 */
public class VirtualMachineResourceClient extends BaseResourceClient {

    public VirtualMachineResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    // --- Core VM Lifecycle Methods ---

    public String create(String pveNodeName, VMCreationOptions options)   {
        String path = String.format("/nodes/%s/qemu", pveNodeName);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Create VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    public VirtualMachineConfig getConfig(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/config", pveNodeName, vmid);
        PveResponse<VirtualMachineConfig> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get VM config data is null", response.getStatusCode(), null, pveNodeName, path));
    }

    public CurrentVirtualMachineStatus getStatus(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/status/current", pveNodeName, vmid);
        PveResponse<CurrentVirtualMachineStatus> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get VM status data is null", response.getStatusCode(), null, pveNodeName, path));
    }

    public String start(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/status/start", pveNodeName, vmid);
        PveResponse<String> response = executor.post(path, null, Collections.emptyMap(), new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Start VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    public String shutdown(String pveNodeName, int vmid, VMLifecycleOptions.ShutdownOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d/status/shutdown", pveNodeName, vmid);
        Map<String, Object> bodyParams = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {}) : Collections.emptyMap();
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Shutdown VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    public String stop(String pveNodeName, int vmid, VMLifecycleOptions.StopOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d/status/stop", pveNodeName, vmid);
        Map<String, Object> bodyParams = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {}) : Collections.emptyMap();
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Stop VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    public String delete(String pveNodeName, int vmid, VMLifecycleOptions.DeleteOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d", pveNodeName, vmid);
        Map<String, String> queryParams = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {}) : Collections.emptyMap();
        PveResponse<String> response = executor.delete(path, queryParams, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Delete VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    public VncConnectionDetails getVncConsole(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/vncproxy", pveNodeName, vmid);
        PveResponse<VncConnectionDetails> response = executor.post(path, null, Collections.emptyMap(), new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get VNC Console data is null", response.getStatusCode(), null, pveNodeName, path));
    }

    // --- Snapshot Management Methods ---

    /**
     * 列出指定虚拟机的所有快照。
     */
    public List<VirtualMachineSnapshot> listSnapshots(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/snapshot", pveNodeName, vmid);
        PveResponse<List<VirtualMachineSnapshot>> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 为虚拟机创建一个新的快照。这是一个异步操作。
     */
    public String createSnapshot(String pveNodeName, int vmid, SnapshotCreationOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d/snapshot", pveNodeName, vmid);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Create snapshot task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 回滚虚拟机到指定的快照状态。这是一个异步操作。
     */
    public String rollbackToSnapshot(String pveNodeName, int vmid, String snapshotName)   {
        String path = String.format("/nodes/%s/qemu/%d/snapshot/%s/rollback", pveNodeName, vmid, snapshotName);
        PveResponse<String> response = executor.post(path, null, Collections.emptyMap(), new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Rollback snapshot task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 删除一个虚拟机的快照。这是一个异步操作。
     */
    public String deleteSnapshot(String pveNodeName, int vmid, String snapshotName)   {
        String path = String.format("/nodes/%s/qemu/%d/snapshot/%s", pveNodeName, vmid, snapshotName);
        PveResponse<String> response = executor.delete(path, null, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Delete snapshot task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 克隆一个虚拟机或模板。这是一个异步操作。
     * @param pveNodeName PVE节点名
     * @param vmidToClone 要克隆的源VMID
     * @param options 克隆选项，必须包含新的vmid
     * @return 克隆任务的UPID
     */
    public String clone(String pveNodeName, int vmidToClone, CloneOptions options)   {
        if (options.getNewid() == null) {
            throw new IllegalArgumentException("New VMID must be specified in CloneOptions.");
        }
        String path = String.format("/nodes/%s/qemu/%d/clone", pveNodeName, vmidToClone);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Clone VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 创建一个虚拟机模板。这是一个异步操作。
     */
    public String createTemplate(String pveNodeName, int vmid)   {
        String path = String.format("/nodes/%s/qemu/%d/template", pveNodeName, vmid);
        PveResponse<String> response = executor.post(path, null, Collections.emptyMap(), new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Create template task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 迁移虚拟机到另一个节点。这是一个异步操作。
     */
    public String migrate(String pveNodeName, int vmid, MigrateOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d/migrate", pveNodeName, vmid);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Migrate VM task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 调整虚拟机磁盘大小。这是一个异步操作。
     */
    public String resizeDisk(String pveNodeName, int vmid, ResizeDiskOptions options)   {
        String path = String.format("/nodes/%s/qemu/%d/resize", pveNodeName, vmid);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.put(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Resize disk task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }

    // --- Backup Management Methods ---

    /**
     * 创建一个虚拟机备份 (vzdump)。这是一个异步操作。
     * @param pveNodeName PVE节点名
     * @param options 备份参数。必须指定vmid和storage。
     * @return 备份任务的UPID
     */
    public String createBackup(String pveNodeName, BackupOptions options)   {
        if (options.getVmid() == null || options.getStorage() == null) {
            throw new IllegalArgumentException("BackupOptions must include vmid and storage.");
        }
        String path = String.format("/nodes/%s/vzdump", pveNodeName);
        Map<String, Object> bodyParams = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        PveResponse<String> response = executor.post(path, null, bodyParams, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Create backup task UPID not returned", response.getStatusCode(), null, pveNodeName, path));
    }


}

