package io.github.pve.client.model.nodes.sdn.zones.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List zone content.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZonesContentIndexResponse {

    /**
     * Status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * Status details
     * Type: string
     * Optional: True
     */
    @JsonProperty("statusmsg")
    private String statusmsg;

    /**
     * Vnet identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vnet")
    private String vnet;


}
