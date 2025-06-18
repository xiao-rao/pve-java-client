package io.github.pve.client.model.cluster.backup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List vzdump backup schedule.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterBackupIndexResponse {

    /**
     * The job ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
