package io.github.pve.client.model.cluster.ha.status.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get HA manger status.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse {

    /**
     * For type 'service'. Service state as seen by the CRM.
     * Type: string
     * Optional: True
     */
    @JsonProperty("crm_state")
    private String crmState;

    /**
     * Status entry ID (quorum, master, lrm:<node>, service:<sid>).
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * For type 'service'.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max_relocate")
    private Integer maxRelocate;

    /**
     * For type 'service'.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max_restart")
    private Integer maxRestart;

    /**
     * Node associated to status entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * For type 'quorum'. Whether the cluster is quorate or not.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("quorate")
    private Boolean quorate;

    /**
     * For type 'service'. Requested service state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("request_state")
    private String requestState;

    /**
     * For type 'service'. Service ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("sid")
    private String sid;

    /**
     * For type 'service'. Verbose service state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * Status of the entry (value depends on type).
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * For type 'lrm','master'. Timestamp of the status information.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timestamp")
    private Integer timestamp;

    /**
     * Type of status entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
