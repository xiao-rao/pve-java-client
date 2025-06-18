package io.github.pve.client.model.cluster.sdn.dns;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SDN dns index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdnDnsIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns")
    private String dns;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
