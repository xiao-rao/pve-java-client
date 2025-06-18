package io.github.pve.client.model.nodes.qemu.agent.fileread;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Reads the given file via guest agent. Is limited to 16777216 bytes.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileReadResponse {

    /**
     * The content of the file, maximum 16777216
     * Type: string
     * Optional: True
     */
    @JsonProperty("content")
    private String content;

    /**
     * If set to 1, the output is truncated and not complete
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("truncated")
    private Boolean truncated;


}
