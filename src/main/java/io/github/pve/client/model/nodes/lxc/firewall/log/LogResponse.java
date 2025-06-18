package io.github.pve.client.model.nodes.lxc.firewall.log;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read firewall log
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogResponse {

    /**
     * Line number
     * Type: integer
     * Optional: True
     */
    @JsonProperty("n")
    private Integer n;

    /**
     * Line text
     * Type: string
     * Optional: True
     */
    @JsonProperty("t")
    private String t;


}
