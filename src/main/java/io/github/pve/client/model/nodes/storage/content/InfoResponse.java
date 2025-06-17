package io.github.pve.client.model.nodes.storage.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get volume attributes
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfoResponse {

    /**
     * Format identifier ('raw', 'qcow2', 'subvol', 'iso', 'tgz' ...)
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * Optional notes.
     * Type: string
     * Optional: True
     */
    @JsonProperty("notes")
    private String notes;

    /**
     * The Path
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;

    /**
     * Protection status. Currently only supported for backups.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protected")
    private Boolean protectedValue;

    /**
     * Volume size in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * Used space. Please note that most storage plugins do not report anything useful here.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("used")
    private Integer used;


}
