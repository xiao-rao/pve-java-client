package io.github.pve.client.model.cluster.sdn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Directory index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterSdnIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
