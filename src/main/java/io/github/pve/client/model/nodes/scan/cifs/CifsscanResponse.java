package io.github.pve.client.model.nodes.scan.cifs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan remote CIFS server.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CifsscanResponse {

    /**
     * Descriptive text from server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * The cifs share name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("share")
    private String share;


}
