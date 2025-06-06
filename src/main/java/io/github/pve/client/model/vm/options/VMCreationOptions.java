package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建虚拟机时的参数选项
 * Corresponds to parameters for POST /nodes/{node}/qemu
 */
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL) // 序列化时忽略null字段
public class VMCreationOptions {
    private Integer vmid; // 虚拟机ID。如果省略，PVE会自动选择一个
    private String name;
    private Integer cores;
    private Long memory; // 内存大小，单位是 MiB
    private Integer sockets;
    private String cpu; // CPU类型, e.g., kvm64, host
    @JsonProperty("scsihw")
    private String scsiHw; // SCSI控制器类型, e.g., virtio-scsi-pci

    // 磁盘配置示例: "local-lvm:10,format=qcow2" (在'local-lvm'存储上创建10GB的qcow2格式磁盘)
    private String scsi0;
    private String virtio0;

    // ISO/CD-ROM配置示例: "iso-images:iso/ubuntu-22.04.iso,media=cdrom"
    private String ide2;

    // 网络配置示例: "virtio,bridge=vmbr0"
    private String net0;

    private String boot; // 启动顺序, e.g., "order=scsi0;ide2"
    @JsonProperty("ostype")
    private String osType; // 操作系统类型, e.g., "l26" for Linux
    private Integer agent; // QEMU Guest Agent, 1 for enabled
    private String description;
    private String tags; // e.g. "tag1;tag2"
    @JsonProperty("pool")
    private String resourcePool; // 资源池名称

    // 可以添加更多高级选项...
}
