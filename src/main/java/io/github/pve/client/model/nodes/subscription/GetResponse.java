package io.github.pve.client.model.nodes.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read subscription info.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetResponse {

    /**
     * Timestamp of the last check done.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("checktime")
    private Integer checktime;

    /**
     * The subscription key, if set and permitted to access.
     * Type: string
     * Optional: True
     */
    @JsonProperty("key")
    private String key;

    /**
     * A short code for the subscription level.
     * Type: string
     * Optional: True
     */
    @JsonProperty("level")
    private String level;

    /**
     * A more human readable status message.
     * Type: string
     * Optional: True
     */
    @JsonProperty("message")
    private String message;

    /**
     * Next due date of the set subscription.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nextduedate")
    private String nextduedate;

    /**
     * Human readable productname of the set subscription.
     * Type: string
     * Optional: True
     */
    @JsonProperty("productname")
    private String productname;

    /**
     * Register date of the set subscription.
     * Type: string
     * Optional: True
     */
    @JsonProperty("regdate")
    private String regdate;

    /**
     * The server ID, if permitted to access.
     * Type: string
     * Optional: True
     */
    @JsonProperty("serverid")
    private String serverId;

    /**
     * Signature for offline keys
     * Type: string
     * Optional: True
     */
    @JsonProperty("signature")
    private String signature;

    /**
     * The number of sockets for this host.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("sockets")
    private Integer sockets;

    /**
     * The current subscription status.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * URL to the web shop.
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;


}
