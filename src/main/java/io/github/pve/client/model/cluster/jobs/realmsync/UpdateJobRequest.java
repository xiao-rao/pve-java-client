package io.github.pve.client.model.cluster.jobs.realmsync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Update realm-sync job definition.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateJobRequest {

    /**
     * Description for the Job.
     * Type: string
     * Optional: True
     */
    @Size(max=512, message="Parameter 'comment' length must not exceed 512")
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
     * Enable newly synced users immediately.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable-new")
    private Boolean enableNew;

    /**
     * Determines if the job is enabled.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * A semicolon-separated list of things to remove when they or the user vanishes during a sync. The following values are possible: 'entry' removes the user/group when not returned from the sync. 'properties' removes the set properties on existing user/group that do not appear in the source (even custom ones). 'acl' removes acls when the user/group is not returned from the sync. Instead of a list it also can be 'none' (the default).
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="(?:(?:(?:acl|properties|entry);)*(?:acl|properties|entry))|none", message="Parameter 'remove-vanished' does not match pattern")
    @JsonProperty("remove-vanished")
    private String removeVanished;

    /**
     * Backup schedule. The format is a subset of `systemd` calendar events.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'schedule' length must not exceed 128")
    @JsonProperty("schedule")
    private String schedule;

    /**
     * Select what to sync.
     * Type: string
     * Optional: True
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
