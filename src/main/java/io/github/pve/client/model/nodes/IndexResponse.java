package io.github.pve.client.model.nodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Cluster node index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * CPU utilization.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpu")
    private Double cpu;

    /**
     * Support level.
     * Type: string
     * Optional: True
     */
    @JsonProperty("level")
    private String level;

    /**
     * Number of available CPUs.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxcpu")
    private Integer maxcpu;

    /**
     * Number of available memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxmem")
    private Integer maxmem;

    /**
     * Used memory in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mem")
    private Integer mem;

    /**
     * The cluster node name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * The SSL fingerprint for the node certificate.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ssl_fingerprint")
    private String sslFingerprint;

    /**
     * Node status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * Node uptime in seconds.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("uptime")
    private Integer uptime;


}
