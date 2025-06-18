package io.github.pve.client.model.cluster.firewall.macros;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List available macros
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMacrosResponse {

    /**
     * More verbose description (if available).
     * Type: string
     * Optional: True
     */
    @JsonProperty("descr")
    private String descr;

    /**
     * Macro name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("macro")
    private String macro;


}
