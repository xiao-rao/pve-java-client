package io.github.pve.client.model.cluster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClusterResource {
    private String id;
    private String node;
    private String status;
    private String type; // e.g., "qemu", "lxc", "storage", "pool"
    private Long maxcpu;
    private Long maxmem;
    private Long maxdisk;
    private Long cpu;
    private Long mem;
    private Long disk;
    private Integer vmid;
    private String name;
    private String pool;
    @JsonProperty("storage")
    private String storageId;
    @JsonProperty("content")
    private String storageContent;
    @JsonProperty("template")
    private Integer template;
    private Long uptime;
}
