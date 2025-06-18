package io.github.pve.client.model.nodes.sdn.zones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get status for all zones.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdnZonesIndexResponse {

    /**
     * Status of zone
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * The SDN zone object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("zone")
    private String zone;


}
