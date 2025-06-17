package io.github.pve.client.model.cluster.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Set datacenter options.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetOptionsRequest {

    /**
     * Set I/O bandwidth limit for various operations (in KiB/s).
     * Type: string
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private String bwlimit;

    /**
     * Consent text that is displayed before logging in.
     * Type: string
     * Optional: True
     */
    @Size(max=65536, message="Parameter 'consent-text' length must not exceed 65536")
    @JsonProperty("consent-text")
    private String consentText;

    /**
     * Select the default Console viewer. You can either use the builtin java applet (VNC; deprecated and maps to html5), an external virt-viewer comtatible application (SPICE), an HTML5 based vnc viewer (noVNC), or an HTML5 based console client (xtermjs). If the selected viewer is not available (e.g. SPICE not activated for the VM), the fallback is noVNC.
     * Type: string
     * Optional: True
     */
    @JsonProperty("console")
    private String console;

    /**
     * Cluster resource scheduling settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("crs")
    private String crs;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

    /**
     * Datacenter description. Shown in the web-interface datacenter notes panel. This is saved as comment inside the configuration file.
     * Type: string
     * Optional: True
     */
    @Size(max=65536, message="Parameter 'description' length must not exceed 65536")
    @JsonProperty("description")
    private String description;

    /**
     * Specify email address to send notification from (default is root@$hostname)
     * Type: string
     * Optional: True
     */
    @JsonProperty("email_from")
    private String emailFrom;

    /**
     * Set the fencing mode of the HA cluster. Hardware mode needs a valid configuration of fence devices in /etc/pve/ha/fence.cfg. With both all two modes are used.  WARNING: 'hardware' and 'both' are EXPERIMENTAL & WIP
     * Type: string
     * Optional: True
     */
    @JsonProperty("fencing")
    private String fencing;

    /**
     * Cluster wide HA settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ha")
    private String ha;

    /**
     * Specify external http proxy which is used for downloads (example: 'http://username:password@host:port/')
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="http://.*", message="Parameter 'http_proxy' does not match pattern")
    @JsonProperty("http_proxy")
    private String httpProxy;

    /**
     * Default keybord layout for vnc server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("keyboard")
    private String keyboard;

    /**
     * Default GUI language.
     * Type: string
     * Optional: True
     */
    @JsonProperty("language")
    private String language;

    /**
     * Prefix for the auto-generated MAC addresses of virtual guests. The default 'BC:24:11' is the OUI assigned by the IEEE to Proxmox Server Solutions GmbH for a 24-bit large MAC block. You're allowed to use this in local networks, i.e., those not directly reachable by the public (e.g., in a LAN or behind NAT).
     * Type: string
     * Optional: True
     */
    @JsonProperty("mac_prefix")
    private String macPrefix;

    /**
     * Defines how many workers (per node) are maximal started  on actions like 'stopall VMs' or task from the ha-manager.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max_workers")
    private Integer maxWorkers;

    /**
     * For cluster wide migration settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("migration")
    private String migration;

    /**
     * Migration is secure using SSH tunnel by default. For secure private networks you can disable it to speed up migration. Deprecated, use the 'migration' property instead!
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("migration_unsecure")
    private Boolean migrationUnsecure;

    /**
     * Control the range for the free VMID auto-selection pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("next-id")
    private String nextId;

    /**
     * Cluster-wide notification settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("notify")
    private String notify;

    /**
     * A list of tags that require a `Sys.Modify` on '/' to set and delete. Tags set here that are also in 'user-tag-access' also require `Sys.Modify`.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="(?:(?^i:[a-z0-9_][a-z0-9_\\-\\+\\.]*);)*(?^i:[a-z0-9_][a-z0-9_\\-\\+\\.]*)", message="Parameter 'registered-tags' does not match pattern")
    @JsonProperty("registered-tags")
    private String registeredTags;

    /**
     * Tag style options.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tag-style")
    private String tagStyle;

    /**
     * u2f
     * Type: string
     * Optional: True
     */
    @JsonProperty("u2f")
    private String u2f;

    /**
     * Privilege options for user-settable tags
     * Type: string
     * Optional: True
     */
    @JsonProperty("user-tag-access")
    private String userTagAccess;

    /**
     * webauthn configuration
     * Type: string
     * Optional: True
     */
    @JsonProperty("webauthn")
    private String webauthn;


}
