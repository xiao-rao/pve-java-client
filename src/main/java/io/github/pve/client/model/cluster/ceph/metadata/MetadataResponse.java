package io.github.pve.client.model.cluster.ceph.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get ceph metadata.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataResponse {

    /**
     * Metadata servers configured in the cluster and their properties.
     * Type: object
     * Optional: True
     */
    @JsonProperty("mds")
    private Object mds;

    /**
     * Managers configured in the cluster and their properties.
     * Type: object
     * Optional: True
     */
    @JsonProperty("mgr")
    private Object mgr;

    /**
     * Monitors configured in the cluster and their properties.
     * Type: object
     * Optional: True
     */
    @JsonProperty("mon")
    private Object mon;

    /**
     * Ceph version installed on the nodes.
     * Type: object
     * Optional: True
     */
    @JsonProperty("node")
    private Object node;

    /**
     * OSDs configured in the cluster and their properties.
     * Type: array
     * Optional: True
     */
    @JsonProperty("osd")
    private List<Object> osd;


}
