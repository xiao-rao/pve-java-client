package io.github.pve.client.model.nodes.scan.glusterfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan remote GlusterFS server.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlusterfsscanResponse {

    /**
     * The volume name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("volname")
    private String volname;


}
