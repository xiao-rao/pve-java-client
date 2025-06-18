package io.github.pve.client.model.cluster.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List recent tasks (cluster wide).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TasksResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("upid")
    private String upId;


}
