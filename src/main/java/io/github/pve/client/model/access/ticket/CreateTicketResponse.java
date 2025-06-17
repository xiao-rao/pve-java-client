package io.github.pve.client.model.access.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Create or verify authentication ticket.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTicketResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("CSRFPreventionToken")
    private String csrfpreventiontoken;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("clustername")
    private String clustername;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ticket")
    private String ticket;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("username")
    private String username;


}
