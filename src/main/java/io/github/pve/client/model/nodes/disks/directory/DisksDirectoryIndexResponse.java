package io.github.pve.client.model.nodes.disks.directory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * PVE Managed Directory storages.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisksDirectoryIndexResponse {

    /**
     * The mounted device.
     * Type: string
     * Optional: True
     */
    @JsonProperty("device")
    private String device;

    /**
     * The mount options.
     * Type: string
     * Optional: True
     */
    @JsonProperty("options")
    private String options;

    /**
     * The mount path.
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;

    /**
     * The filesystem type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * The path of the mount unit.
     * Type: string
     * Optional: True
     */
    @JsonProperty("unitfile")
    private String unitfile;


}
