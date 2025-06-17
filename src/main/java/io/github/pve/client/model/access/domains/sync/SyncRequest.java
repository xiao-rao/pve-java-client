package io.github.pve.client.model.access.domains.sync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

/**
 * Syncs users and/or groups from the configured LDAP to user.cfg. NOTE: Synced groups will have the name 'name-$realm', so make sure those groups do not exist to prevent overwriting.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SyncRequest {

    /**
     * If set, does not write anything.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("dry-run")
    private Boolean dryRun;

    /**
     * Enable newly synced users immediately.
     * Type: boolean
     * Optional: False
     */
    @JsonProperty("enable-new")
    private Boolean enableNew;

    /**
     * DEPRECATED: use 'remove-vanished' instead. If set, uses the LDAP Directory as source of truth, deleting users or groups not returned from the sync and removing all locally modified properties of synced users. If not set, only syncs information which is present in the synced data, and does not delete or modify anything else.
     * Type: boolean
     * Optional: False
     */
    @JsonProperty("full")
    private Boolean full;

    /**
     * DEPRECATED: use 'remove-vanished' instead. Remove ACLs for users or groups which were removed from the config during a sync.
     * Type: boolean
     * Optional: False
     */
    @JsonProperty("purge")
    private Boolean purge;

    /**
     * A semicolon-separated list of things to remove when they or the user vanishes during a sync. The following values are possible: 'entry' removes the user/group when not returned from the sync. 'properties' removes the set properties on existing user/group that do not appear in the source (even custom ones). 'acl' removes acls when the user/group is not returned from the sync. Instead of a list it also can be 'none' (the default).
     * Type: string
     * Optional: False
     */
    @Pattern(regexp="(?:(?:(?:acl|properties|entry);)*(?:acl|properties|entry))|none", message="Parameter 'remove-vanished' does not match pattern")
    @JsonProperty("remove-vanished")
    private String removeVanished;

    /**
     * Select what to sync.
     * Type: string
     * Optional: False
     */
    @JsonProperty("scope")
    private String scope;


}
