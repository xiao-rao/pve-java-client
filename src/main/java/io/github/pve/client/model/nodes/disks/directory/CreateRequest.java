package io.github.pve.client.model.nodes.disks.directory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create a Filesystem on an unused disk. Will be mounted under '/mnt/pve/NAME'.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Configure storage using the directory.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("add_storage")
    private Boolean addStorage;

    /**
     * The block device you want to create the filesystem on.
     * Type: string
     * Optional: True
     */
    @JsonProperty("device")
    private String device;

    /**
     * The desired filesystem.
     * Type: string
     * Optional: True
     */
    @JsonProperty("filesystem")
    private String filesystem;

    /**
     * The storage identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
