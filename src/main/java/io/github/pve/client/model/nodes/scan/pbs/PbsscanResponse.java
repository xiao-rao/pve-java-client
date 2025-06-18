package io.github.pve.client.model.nodes.scan.pbs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan remote Proxmox Backup Server.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PbsscanResponse {

    /**
     * Comment from server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * The datastore name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("store")
    private String store;


}
