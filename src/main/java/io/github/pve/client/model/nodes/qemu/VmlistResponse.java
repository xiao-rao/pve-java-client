package io.github.pve.client.model.nodes.qemu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Virtual machine index (per node).
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
     * Root disk size in bytes.
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
     * Currently used memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mem")
    private Integer mem;

    /**
     * VM (host)name.
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
     * PID of the QEMU process, if the VM is running.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pid")
    private Integer pid;

    /**
     * VM run state from the 'query-status' QMP monitor command.
     * Type: string
     * Optional: True
     */
    @JsonProperty("qmpstatus")
    private String qmpstatus;

    /**
     * The currently running machine type (if running).
     * Type: string
     * Optional: True
     */
    @JsonProperty("running-machine")
    private String runningMachine;

    /**
     * The QEMU version the VM is currently using (if running).
     * Type: string
     * Optional: True
     */
    @JsonProperty("running-qemu")
    private String runningQemu;

    /**
     * Guest has serial device configured.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("serial")
    private Boolean serial;

    /**
     * QEMU process status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * The current configured tags, if any
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
