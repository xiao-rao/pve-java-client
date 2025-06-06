package io.github.pve.client.model.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * 虚拟机的当前状态
 * Corresponds to response from GET /nodes/{node}/qemu/{vmid}/status/current
 */
@Data
public class CurrentVirtualMachineStatus {
    private String status; // "running", "stopped"
    @JsonProperty("qmpstatus")
    private String qmpStatus; // "running", "stopped"
    private String name;
    private Integer vmid;
    private Long uptime;
    private Map<String, Integer> ha;
    private Boolean agent;
    private Long cpus;
    private Long maxdisk;
    private Long maxmem;
    private String lock; // 如果被锁定，会显示锁类型，例如 "backup"
    // ... more fields
}
