package io.github.pve.client.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 存储中的内容项信息 (例如 ISO, 磁盘镜像, 备份文件)
 * Corresponds to an item in the response from GET /nodes/{node}/storage/{storageid}/content
 */
@Data
public class StorageContentItem {

    /**
     * Volume identifier.
     */
    private String volid;

    /**
     * Content type.
     */
    private String content;

    /**
     * Creation time (epoch).
     */
    private Long ctime;

    /**
     * Format of the volume.
     */
    private String format;

    /**
     * Volume size in bytes.
     */
    private Long size;

    /**
     * The VM ID associated with the volume (for backups, disks).
     */
    private Integer vmid;

    /**
     * The name of the backup file (for backups).
     */
    private String name;

    /**
     * For backups, the notes associated with the backup.
     */
    private String notes;

    /**
     * The parent volume ID (for linked clones).
     */
    private String parent;

    /**
     * For backups, the encryption key status.
     */
    @JsonProperty("encrypted")
    private String encrypted;

    /**
     * For backups, the verification status.
     */
    @JsonProperty("verification")
    private String verification;

    /**
     * The VM name associated with the volume (for backups, disks).
     */
    @JsonProperty("vmname")
    private String vmName;
}
