package io.github.pve.client.model.cluster.replication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update replication job configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'comment' length must not exceed 4096")
    @JsonProperty("comment")
    private String comment;

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
     * Flag to disable/deactivate the entry.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * Rate limit in mbps (megabytes per second) as floating point number.
     * Type: number
     * Optional: True
     */
    @JsonProperty("rate")
    private Double rate;

    /**
     * Mark the replication job for removal. The job will remove all local replication snapshots. When set to 'full', it also tries to remove replicated volumes on the target. The job then removes itself from the configuration file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("remove_job")
    private String removeJob;

    /**
     * Storage replication schedule. The format is a subset of `systemd` calendar events.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'schedule' length must not exceed 128")
    @JsonProperty("schedule")
    private String schedule;

    /**
     * For internal use, to detect if the guest was stolen.
     * Type: string
     * Optional: True
     */
    @JsonProperty("source")
    private String source;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
