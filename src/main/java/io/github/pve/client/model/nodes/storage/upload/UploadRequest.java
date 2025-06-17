package io.github.pve.client.model.nodes.storage.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Upload templates, ISO images, OVAs and VM images.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadRequest {

    /**
     * The expected checksum of the file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("checksum")
    private String checksum;

    /**
     * The algorithm to calculate the checksum of the file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("checksum-algorithm")
    private String checksumAlgorithm;

    /**
     * Content type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("content")
    private String content;

    /**
     * The name of the file to create. Caution: This will be normalized!
     * Type: string
     * Optional: True
     */
    @Size(max=255, message="Parameter 'filename' length must not exceed 255")
    @JsonProperty("filename")
    private String filename;

    /**
     * The source file name. This parameter is usually set by the REST handler. You can only overwrite it when connecting to the trusted port on localhost.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="/var/tmp/pveupload-[0-9a-f]+", message="Parameter 'tmpfilename' does not match pattern")
    @JsonProperty("tmpfilename")
    private String tmpfilename;


}
