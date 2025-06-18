package io.github.pve.client.model.cluster.backupinfo.notbackedup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Shows all guests which are not covered by any backup job.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetGuestsNotInBackupResponse {

    /**
     * Name of the guest
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Type of the guest.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * VMID of the guest.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vmid")
    private Integer vmId;


}
