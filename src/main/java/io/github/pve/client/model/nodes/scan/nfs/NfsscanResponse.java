package io.github.pve.client.model.nodes.scan.nfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan remote NFS server.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NfsscanResponse {

    /**
     * NFS export options.
     * Type: string
     * Optional: True
     */
    @JsonProperty("options")
    private String options;

    /**
     * The exported path.
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;


}
