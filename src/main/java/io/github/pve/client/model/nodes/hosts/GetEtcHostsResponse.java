package io.github.pve.client.model.nodes.hosts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get the content of /etc/hosts.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEtcHostsResponse {

    /**
     * The content of /etc/hosts.
     * Type: string
     * Optional: True
     */
    @JsonProperty("data")
    private String data;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @JsonProperty("digest")
    private String digest;


}
