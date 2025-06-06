package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建虚拟机备份 (vzdump) 时的参数选项
 * Corresponds to parameters for POST /nodes/{node}/vzdump
 */
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BackupOptions {
    /**
     * The storage identifier.
     */
    private String storage;

    /**
     * The VMIDs to be backed up. Can be a single vmid or "all".
     */
    private String vmid;

    /**
     * Backup mode.
     */
    private Mode mode;

    /**
     * Compression algorithm.
     */
    private Compression compress;

    /**
     * Send email notification to this address.
     */
    private String mailto;

    /**
     * A descriptive note for the backup.
     */
    private String notes;

    /**
     * Exclude a specific disk from the backup.
     */
    @JsonProperty("exclude")
    private String excludeDisk;

    /**
     * Prune old backups according to the given retention options.
     */
    @JsonProperty("prune-backups")
    private String pruneBackups; // Example: "keep-last=3,keep-daily=7"

    /**
     * The hook script to execute.
     */
    private String script;

    /**
     * Only run on this specific node.
     */
    private String node;

    /**
     * Backup all VMs.
     */
    private Boolean all;

    /**
     * Use pigz instead of gzip when compressing with gzip.
     */
    private Boolean pigz;

    /**
     * Set the IO priority for the backup job.
     */
    @JsonProperty("ionice")
    private Integer ioNice;

    /**
     * Stop the VM before starting the backup.
     */
    @JsonProperty("stop")
    private Boolean stop;

    /**
     * Remove the backup job from the queue if the VM is locked.
     */
    @JsonProperty("remove")
    private Boolean remove;

    /**
     * Backup mode enum.
     */
    public enum Mode {
        @JsonProperty("snapshot")
        SNAPSHOT,
        @JsonProperty("suspend")
        SUSPEND,
        @JsonProperty("stop")
        STOP
    }

    /**
     * Compression algorithm enum.
     */
    public enum Compression {
        @JsonProperty("0") // Raw format, no compression
        NONE,
        @JsonProperty("gzip")
        GZIP,
        @JsonProperty("lzo")
        LZO,
        @JsonProperty("zstd")
        ZSTD
    }
}
