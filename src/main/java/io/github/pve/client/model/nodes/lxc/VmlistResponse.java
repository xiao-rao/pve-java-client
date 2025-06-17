package io.github.pve.client.model.nodes.lxc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * LXC container index (per node).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmlistResponse {

    /**
     * Current CPU usage.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpu")
    private Double cpu;

    /**
     * Maximum usable CPUs.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpus")
    private Double cpus;

    /**
     * Root disk image space-usage in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("disk")
    private Integer disk;

    /**
     * The amount of bytes the guest read from it's block devices since the guest was started. (Note: This info is not available for all storage types.)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("diskread")
    private Integer diskread;

    /**
     * The amount of bytes the guest wrote from it's block devices since the guest was started. (Note: This info is not available for all storage types.)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("diskwrite")
    private Integer diskwrite;

    /**
     * The current config lock, if any.
     * Type: string
     * Optional: True
     */
    @JsonProperty("lock")
    private String lock;

    /**
     * Root disk image size in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxdisk")
    private Integer maxdisk;

    /**
     * Maximum memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxmem")
    private Integer maxmem;

    /**
     * Maximum SWAP memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxswap")
    private Integer maxswap;

    /**
     * Currently used memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mem")
    private Integer mem;

    /**
     * Container name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * The amount of traffic in bytes that was sent to the guest over the network since it was started.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("netin")
    private Integer netin;

    /**
     * The amount of traffic in bytes that was sent from the guest over the network since it was started.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("netout")
    private Integer netout;

    /**
     * LXC Container status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * The current configured tags, if any.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * Determines if the guest is a template.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("template")
    private Boolean template;

    /**
     * Uptime in seconds.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("uptime")
    private Integer uptime;

    /**
     * The (unique) ID of the VM.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vmid")
    private Integer vmid;


}
