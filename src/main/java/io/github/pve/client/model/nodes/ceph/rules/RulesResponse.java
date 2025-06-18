package io.github.pve.client.model.nodes.ceph.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List ceph rules.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RulesResponse {

    /**
     * Name of the CRUSH rule.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
