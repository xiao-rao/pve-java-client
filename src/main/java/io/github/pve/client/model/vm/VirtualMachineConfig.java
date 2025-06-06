package io.github.pve.client.model.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * 虚拟机配置详情
 * Corresponds to response from GET /nodes/{node}/qemu/{vmid}/config
 */
@Data
public class VirtualMachineConfig {
    private String name;
    private Integer cores;
    private Long memory;
    private String digest; // 配置摘要，用于检测变更
    private String net0;
    private String scsi0;
    private String ide2;
    private String virtio0;
    private String boot;
    @JsonProperty("ostype")
    private String osType;
    @JsonProperty("scsihw")
    private String scsiHw;
    private Boolean agent;
    private Map<String, String> tags;
    // ... 可以根据需要添加更多字段，例如 vga, serial, usb 等
}
