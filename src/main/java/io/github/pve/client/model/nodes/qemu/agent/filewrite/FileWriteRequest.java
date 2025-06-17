package io.github.pve.client.model.nodes.qemu.agent.filewrite;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Writes the given file via guest agent.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileWriteRequest {

    /**
     * The content to write into the file.
     * Type: string
     * Optional: True
     */
    @Size(max=61440, message="Parameter 'content' length must not exceed 61440")
    @JsonProperty("content")
    private String content;

    /**
     * If set, the content will be encoded as base64 (required by QEMU).Otherwise the content needs to be encoded beforehand - defaults to true.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("encode")
    private Boolean encode;

    /**
     * The path to the file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("file")
    private String file;


}
