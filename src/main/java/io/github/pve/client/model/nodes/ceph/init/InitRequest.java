package io.github.pve.client.model.nodes.ceph.init;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Create initial ceph default configuration and setup symlinks.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitRequest {

    /**
     * Declare a separate cluster network, OSDs will routeheartbeat, object replication and recovery traffic over it
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'cluster-network' length must not exceed 128")
    @JsonProperty("cluster-network")
    private String clusterNetwork;

    /**
     * Disable cephx authentication.  WARNING: cephx is a security feature protecting against man-in-the-middle attacks. Only consider disabling cephx if your network is private!
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable_cephx")
    private Boolean disableCephx;

    /**
     * Minimum number of available replicas per object to allow I/O
     * Type: integer
     * Optional: True
     */
    @JsonProperty("min_size")
    private Integer minSize;

    /**
     * Use specific network for all ceph related traffic
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'network' length must not exceed 128")
    @JsonProperty("network")
    private String network;

    /**
     * Placement group bits, used to specify the default number of placement groups.  Depreacted. This setting was deprecated in recent Ceph versions.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pg_bits")
    private Integer pgBits;

    /**
     * Targeted number of replicas per object
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;


}
