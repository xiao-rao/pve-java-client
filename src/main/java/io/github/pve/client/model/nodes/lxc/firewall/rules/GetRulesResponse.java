package io.github.pve.client.model.nodes.lxc.firewall.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List rules.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetRulesResponse {

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pos")
    private Integer pos;


}
