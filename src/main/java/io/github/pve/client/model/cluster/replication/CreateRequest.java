package io.github.pve.client.model.cluster.replication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

/**
 * Create a new replication job
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'comment' length must not exceed 4096")
    @JsonProperty("comment")
    private String comment;

    /**
     * Flag to disable/deactivate the entry.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * Replication Job ID. The ID is composed of a Guest ID and a job number, separated by a hyphen, i.e. '<GUEST>-<JOBNUM>'.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="[1-9][0-9]{2,8}-\\d{1,9}", message="Parameter 'id' does not match pattern")
    @JsonProperty("id")
    private String id;

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
     * Target node.
     * Type: string
     * Optional: False
     */
    @NotNull(message = "Parameter 'target' must not be null")
    @JsonProperty("target")
    private String target;

    /**
     * Section type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
