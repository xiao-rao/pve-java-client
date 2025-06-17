package io.github.pve.client.model.cluster.jobs.realmsync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List configured realm-sync-jobs.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SyncjobIndexResponse {

    /**
     * A comment for the job.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * If the job is enabled or not.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * The ID of the entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * Last execution time of the job in seconds since the beginning of the UNIX epoch
     * Type: integer
     * Optional: True
     */
    @JsonProperty("last-run")
    private Integer lastRun;

    /**
     * Next planned execution time of the job in seconds since the beginning of the UNIX epoch.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("next-run")
    private Integer nextRun;

    /**
     * Authentication domain ID
     * Type: string
     * Optional: True
     */
    @JsonProperty("realm")
    private String realm;

    /**
     * A semicolon-separated list of things to remove when they or the user vanishes during a sync. The following values are possible: 'entry' removes the user/group when not returned from the sync. 'properties' removes the set properties on existing user/group that do not appear in the source (even custom ones). 'acl' removes acls when the user/group is not returned from the sync. Instead of a list it also can be 'none' (the default).
     * Type: string
     * Optional: False
     */
    @JsonProperty("remove-vanished")
    private String removeVanished;

    /**
     * The configured sync schedule.
     * Type: string
     * Optional: True
     */
    @JsonProperty("schedule")
    private String schedule;

    /**
     * Select what to sync.
     * Type: string
     * Optional: False
     */
    @JsonProperty("scope")
    private String scope;


}
