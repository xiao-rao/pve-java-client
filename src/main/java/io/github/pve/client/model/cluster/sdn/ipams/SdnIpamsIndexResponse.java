package io.github.pve.client.model.cluster.sdn.ipams;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SDN ipams index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdnIpamsIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ipam")
    private String ipam;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
