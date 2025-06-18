package io.github.pve.client.model.nodes.queryurlmetadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Query metadata of an URL: file size, file name and mime type.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryUrlMetadataResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("filename")
    private String filename;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("mimetype")
    private String mimetype;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;


}
