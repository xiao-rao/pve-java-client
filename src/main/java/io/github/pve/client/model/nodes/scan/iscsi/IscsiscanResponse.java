package io.github.pve.client.model.nodes.scan.iscsi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan remote iSCSI server.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IscsiscanResponse {

    /**
     * The iSCSI portal name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("portal")
    private String portal;

    /**
     * The iSCSI target name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target")
    private String target;


}
