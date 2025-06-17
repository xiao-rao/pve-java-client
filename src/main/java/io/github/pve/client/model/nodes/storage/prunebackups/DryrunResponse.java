package io.github.pve.client.model.nodes.storage.prunebackups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get prune information for backups. NOTE: this is only a preview and might not be what a subsequent prune call does if backups are removed/added in the meantime.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DryrunResponse {

    /**
     * Creation time of the backup (seconds since the UNIX epoch).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ctime")
    private Integer ctime;

    /**
     * Whether the backup would be kept or removed. Backups that are protected or don't use the standard naming scheme are not removed.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mark")
    private String mark;

    /**
     * One of 'qemu', 'lxc', 'openvz' or 'unknown'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * The VM the backup belongs to.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vmid")
    private Integer vmid;

    /**
     * Backup volume ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("volid")
    private String volid;


}
