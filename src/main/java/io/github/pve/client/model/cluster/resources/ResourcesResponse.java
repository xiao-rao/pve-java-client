package io.github.pve.client.model.cluster.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Resources index (cluster wide).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourcesResponse {

    /**
     * The cgroup mode the node operates under (for type 'node').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("cgroup-mode")
    private Integer cgroupMode;

    /**
     * Allowed storage content types (for type 'storage').
     * Type: string
     * Optional: True
     */
    @JsonProperty("content")
    private String content;

    /**
     * CPU utilization (for types 'node', 'qemu' and 'lxc').
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpu")
    private Double cpu;

    /**
     * Used disk space in bytes (for type 'storage'), used root image space for VMs (for types 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("disk")
    private Integer disk;

    /**
     * The amount of bytes the guest read from its block devices since the guest was started. This info is not available for all storage types. (for types 'qemu' and 'lxc')
     * Type: integer
     * Optional: True
     */
    @JsonProperty("diskread")
    private Integer diskread;

    /**
     * The amount of bytes the guest wrote to its block devices since the guest was started. This info is not available for all storage types. (for types 'qemu' and 'lxc')
     * Type: integer
     * Optional: True
     */
    @JsonProperty("diskwrite")
    private Integer diskwrite;

    /**
     * HA service status (for HA managed VMs).
     * Type: string
     * Optional: True
     */
    @JsonProperty("hastate")
    private String hastate;

    /**
     * Resource id.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * Support level (for type 'node').
     * Type: string
     * Optional: True
     */
    @JsonProperty("level")
    private String level;

    /**
     * The guest's current config lock (for types 'qemu' and 'lxc')
     * Type: string
     * Optional: True
     */
    @JsonProperty("lock")
    private String lock;

    /**
     * Number of available CPUs (for types 'node', 'qemu' and 'lxc').
     * Type: number
     * Optional: True
     */
    @JsonProperty("maxcpu")
    private Double maxcpu;

    /**
     * Storage size in bytes (for type 'storage'), root image size for VMs (for types 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxdisk")
    private Integer maxdisk;

    /**
     * Number of available memory in bytes (for types 'node', 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxmem")
    private Integer maxmem;

    /**
     * Used memory in bytes (for types 'node', 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mem")
    private Integer mem;

    /**
     * Name of the resource.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * The amount of traffic in bytes that was sent to the guest over the network since it was started. (for types 'qemu' and 'lxc')
     * Type: integer
     * Optional: True
     */
    @JsonProperty("netin")
    private Integer netin;

    /**
     * The amount of traffic in bytes that was sent from the guest over the network since it was started. (for types 'qemu' and 'lxc')
     * Type: integer
     * Optional: True
     */
    @JsonProperty("netout")
    private Integer netout;

    /**
     * The cluster node name (for types 'node', 'storage', 'qemu', and 'lxc').
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * More specific type, if available.
     * Type: string
     * Optional: True
     */
    @JsonProperty("plugintype")
    private String plugintype;

    /**
     * The pool name (for types 'pool', 'qemu' and 'lxc').
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool")
    private String pool;

    /**
     * Resource type dependent status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * The storage identifier (for type 'storage').
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * The guest's tags (for types 'qemu' and 'lxc')
     * Type: string
     * Optional: True
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * Determines if the guest is a template. (for types 'qemu' and 'lxc')
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("template")
    private Boolean template;

    /**
     * Resource type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * Uptime of node or virtual guest in seconds (for types 'node', 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("uptime")
    private Integer uptime;

    /**
     * The numerical vmid (for types 'qemu' and 'lxc').
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vmid")
    private Integer vmId;


}
