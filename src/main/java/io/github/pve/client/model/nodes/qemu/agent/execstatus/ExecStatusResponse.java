package io.github.pve.client.model.nodes.qemu.agent.execstatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Gets the status of the given pid started by the guest-agent
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExecStatusResponse {

    /**
     * stderr of the process
     * Type: string
     * Optional: True
     */
    @JsonProperty("err-data")
    private String errData;

    /**
     * true if stderr was not fully captured
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("err-truncated")
    private Boolean errTruncated;

    /**
     * process exit code if it was normally terminated.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("exitcode")
    private Integer exitcode;

    /**
     * Tells if the given command has exited yet.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("exited")
    private Boolean exited;

    /**
     * stdout of the process
     * Type: string
     * Optional: True
     */
    @JsonProperty("out-data")
    private String outData;

    /**
     * true if stdout was not fully captured
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("out-truncated")
    private Boolean outTruncated;

    /**
     * signal number or exception code if the process was abnormally terminated.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("signal")
    private Integer signal;


}
