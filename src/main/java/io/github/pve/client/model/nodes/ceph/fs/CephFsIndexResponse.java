package io.github.pve.client.model.nodes.ceph.fs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Directory index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CephFsIndexResponse {

    /**
     * The name of the data pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("data_pool")
    private String dataPool;

    /**
     * The name of the metadata pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("metadata_pool")
    private String metadataPool;

    /**
     * The ceph filesystem name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
