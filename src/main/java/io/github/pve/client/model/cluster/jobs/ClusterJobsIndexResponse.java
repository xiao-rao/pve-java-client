package io.github.pve.client.model.cluster.jobs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Index for jobs related endpoints.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterJobsIndexResponse {

    /**
     * API sub-directory endpoint
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;


}
