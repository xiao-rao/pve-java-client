package io.github.pve.client.model.nodes.vzdump.defaults;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get the currently configured vzdump defaults.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultsResponse {

    /**
     * Backup all known guest systems on this host.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("all")
    private Boolean all;

    /**
     * Limit I/O bandwidth (in KiB/s).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Integer bwlimit;

    /**
     * Compress dump file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("compress")
    private String compress;

    /**
     * Store resulting files to specified directory.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dumpdir")
    private String dumpdir;

    /**
     * Exclude specified guest systems (assumes --all)
     * Type: string
     * Optional: True
     */
    @JsonProperty("exclude")
    private String exclude;

    /**
     * Exclude certain files/directories (shell globs). Paths starting with '/' are anchored to the container's root, other paths match relative to each subdirectory.
     * Type: array
     * Optional: True
     */
    @JsonProperty("exclude-path")
    private List<String> excludePath;

    /**
     * Options for backup fleecing (VM only).
     * Type: string
     * Optional: True
     */
    @JsonProperty("fleecing")
    private String fleecing;

    /**
     * Set IO priority when using the BFQ scheduler. For snapshot and suspend mode backups of VMs, this only affects the compressor. A value of 8 means the idle priority is used, otherwise the best-effort priority is used with the specified value.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ionice")
    private Integer ionice;

    /**
     * Maximal time to wait for the global lock (minutes).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("lockwait")
    private Integer lockwait;

    /**
     * Deprecated: use notification targets/matchers instead. Specify when to send a notification mail
     * Type: string
     * Optional: True
     */
    @JsonProperty("mailnotification")
    private String mailnotification;

    /**
     * Deprecated: Use notification targets/matchers instead. Comma-separated list of email addresses or users that should receive email notifications.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mailto")
    private String mailto;

    /**
     * Deprecated: use 'prune-backups' instead. Maximal number of backup files per guest system.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxfiles")
    private Integer maxfiles;

    /**
     * Backup mode.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mode")
    private String mode;

    /**
     * Only run if executed on this node.
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * Template string for generating notes for the backup(s). It can contain variables which will be replaced by their values. Currently supported are {{cluster}}, {{guestname}}, {{node}}, and {{vmid}}, but more might be added in the future. Needs to be a single line, newline and backslash need to be escaped as '\n' and '\\' respectively.
     * Type: string
     * Optional: True
     */
    @JsonProperty("notes-template")
    private String notesTemplate;

    /**
     * Determine which notification system to use. If set to 'legacy-sendmail', vzdump will consider the mailto/mailnotification parameters and send emails to the specified address(es) via the 'sendmail' command. If set to 'notification-system', a notification will be sent via PVE's notification system, and the mailto and mailnotification will be ignored. If set to 'auto' (default setting), an email will be sent if mailto is set, and the notification system will be used if not.
     * Type: string
     * Optional: True
     */
    @JsonProperty("notification-mode")
    private String notificationMode;

    /**
     * Deprecated: Do not use
     * Type: string
     * Optional: True
     */
    @JsonProperty("notification-policy")
    private String notificationPolicy;

    /**
     * Deprecated: Do not use
     * Type: string
     * Optional: True
     */
    @JsonProperty("notification-target")
    private String notificationTarget;

    /**
     * PBS mode used to detect file changes and switch encoding format for container backups.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pbs-change-detection-mode")
    private String pbsChangeDetectionMode;

    /**
     * Other performance-related settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("performance")
    private String performance;

    /**
     * Use pigz instead of gzip when N>0. N=1 uses half of cores, N>1 uses N as thread count.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pigz")
    private Integer pigz;

    /**
     * Backup all known guest systems included in the specified pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool")
    private String pool;

    /**
     * If true, mark backup(s) as protected.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protected")
    private Boolean protectedValue;

    /**
     * Use these retention options instead of those from the storage configuration.
     * Type: string
     * Optional: True
     */
    @JsonProperty("prune-backups")
    private String pruneBackups;

    /**
     * Be quiet.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("quiet")
    private Boolean quiet;

    /**
     * Prune older backups according to 'prune-backups'.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("remove")
    private Boolean remove;

    /**
     * Use specified hook script.
     * Type: string
     * Optional: True
     */
    @JsonProperty("script")
    private String script;

    /**
     * Exclude temporary files and logs.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("stdexcludes")
    private Boolean stdexcludes;

    /**
     * Stop running backup jobs on this host.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("stop")
    private Boolean stop;

    /**
     * Maximal time to wait until a guest system is stopped (minutes).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("stopwait")
    private Integer stopwait;

    /**
     * Store resulting file to this storage.
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * Store temporary files to specified directory.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tmpdir")
    private String tmpdir;

    /**
     * The ID of the guest system you want to backup.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vmid")
    private String vmId;

    /**
     * Zstd threads. N=0 uses half of the available cores, if N is set to a value bigger than 0, N is used as thread count.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("zstd")
    private Integer zstd;


}
