package io.github.pve.client.model.nodes.storage.downloadurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Download templates, ISO images, OVAs and VM images by using an URL.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DownloadUrlRequest {

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
     * Decompress the downloaded file using the specified compression algorithm.
     * Type: string
     * Optional: True
     */
    @JsonProperty("compression")
    private String compression;

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
     * The URL to download the file from.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="https?://.*", message="Parameter 'url' does not match pattern")
    @JsonProperty("url")
    private String url;

    /**
     * If false, no SSL/TLS certificates will be verified.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("verify-certificates")
    private Boolean verifyCertificates;


}
