package io.github.pve.client.model.cluster.backupinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Index for backup info related endpoints
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterBackupinfoIndexResponse {

    /**
     * API sub-directory endpoint
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;


}
