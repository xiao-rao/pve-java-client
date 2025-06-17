package io.github.pve.client.model.nodes.dns;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read DNS settings.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsResponse {

    /**
     * First name server IP address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns1")
    private String dns1;

    /**
     * Second name server IP address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns2")
    private String dns2;

    /**
     * Third name server IP address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns3")
    private String dns3;

    /**
     * Search domain for host-name lookup.
     * Type: string
     * Optional: True
     */
    @JsonProperty("search")
    private String search;


}
