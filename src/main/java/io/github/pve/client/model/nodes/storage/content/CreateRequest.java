package io.github.pve.client.model.nodes.storage.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

/**
 * Allocate disk images.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * The name of the file to create.
     * Type: string
     * Optional: True
     */
    @JsonProperty("filename")
    private String filename;

    /**
     * Format of the image.
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * Size in kilobyte (1024 bytes). Optional suffixes 'M' (megabyte, 1024K) and 'G' (gigabyte, 1024M)
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="\\d+[MG]?", message="Parameter 'size' does not match pattern")
    @JsonProperty("size")
    private String size;

    /**
     * Path parameter: vmid
     * Type: string
     * Optional: True
     */
    @JsonProperty("vmid")
    private String vmId;


}
