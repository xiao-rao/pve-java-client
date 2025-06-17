package io.github.pve.client.model.nodes.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Read node status
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse {

    /**
     * Meta-information about the boot mode.
     * Type: object
     * Optional: True
     */
    @JsonProperty("boot-info")
    private Object bootInfo;

    /**
     * The current cpu usage.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpu")
    private Double cpu;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("cpuinfo")
    private Object cpuinfo;

    /**
     * Meta-information about the currently booted kernel of this node.
     * Type: object
     * Optional: True
     */
    @JsonProperty("current-kernel")
    private Object currentKernel;

    /**
     * An array of load avg for 1, 5 and 15 minutes respectively.
     * Type: array
     * Optional: True
     */
    @JsonProperty("loadavg")
    private List<String> loadavg;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("memory")
    private Object memory;

    /**
     * The PVE version string.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pveversion")
    private String pveversion;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("rootfs")
    private Object rootfs;


}
