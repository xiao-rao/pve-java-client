package io.github.pve.client.model.nodes.storage.filerestore.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List files and directories for single file restore under the given path.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse {

    /**
     * base64 path of the current entry
     * Type: string
     * Optional: True
     */
    @JsonProperty("filepath")
    private String filepath;

    /**
     * If this entry is a leaf in the directory graph.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("leaf")
    private Boolean leaf;

    /**
     * Entry last-modified time (unix timestamp).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mtime")
    private Integer mtime;

    /**
     * Entry file size.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * Entry display text.
     * Type: string
     * Optional: True
     */
    @JsonProperty("text")
    private String text;

    /**
     * Entry type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
