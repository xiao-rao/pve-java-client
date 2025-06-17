package io.github.pve.client.model.cluster.metrics.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update metric server configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * An API path prefix inserted between '<host>:<port>/' and '/api2/'. Can be useful if the InfluxDB service runs behind a reverse proxy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("api-path-prefix")
    private String apiPathPrefix;

    /**
     * The InfluxDB bucket/db. Only necessary when using the http v2 api.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bucket")
    private String bucket;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Flag to disable the plugin.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("influxdbproto")
    private String influxdbproto;

    /**
     * InfluxDB max-body-size in bytes. Requests are batched up to this size.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max-body-size")
    private Integer maxBodySize;

    /**
     * MTU for metrics transmission over UDP
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mtu")
    private Integer mtu;

    /**
     * The InfluxDB organization. Only necessary when using the http v2 api. Has no meaning when using v2 compatibility api.
     * Type: string
     * Optional: True
     */
    @JsonProperty("organization")
    private String organization;

    /**
     * root graphite path (ex: proxmox.mycluster.mykey)
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;

    /**
     * server network port
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * Protocol to send graphite data. TCP or UDP (default)
     * Type: string
     * Optional: True
     */
    @JsonProperty("proto")
    private String proto;

    /**
     * server dns name or IP address
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;

    /**
     * graphite TCP socket timeout (default=1)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * The InfluxDB access token. Only necessary when using the http v2 api. If the v2 compatibility api is used, use 'user:password' instead.
     * Type: string
     * Optional: True
     */
    @JsonProperty("token")
    private String token;

    /**
     * Set to 0 to disable certificate verification for https endpoints.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("verify-certificate")
    private Boolean verifyCertificate;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
