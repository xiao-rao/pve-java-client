package io.github.pve.client.model.nodes.qemu.agent.exec;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Executes the given command in the vm via the guest-agent and returns an object with the pid.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExecResponse {

    /**
     * The PID of the process started by the guest-agent.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pid")
    private Integer pId;


}
