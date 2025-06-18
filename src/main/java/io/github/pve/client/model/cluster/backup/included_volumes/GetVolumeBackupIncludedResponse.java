package io.github.pve.client.model.cluster.backup.included_volumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Returns included guests and the backup status of their disks. Optimized to be used in ExtJS tree views.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetVolumeBackupIncludedResponse {

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("children")
    private List<Object> children;


}
