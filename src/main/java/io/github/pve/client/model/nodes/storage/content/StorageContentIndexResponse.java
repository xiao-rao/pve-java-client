package io.github.pve.client.model.nodes.storage.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List storage content.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageContentIndexResponse {

    /**
     * Creation time (seconds since the UNIX Epoch).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ctime")
    private Integer ctime;

    /**
     * If whole backup is encrypted, value is the fingerprint or '1'  if encrypted. Only useful for the Proxmox Backup Server storage type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("encrypted")
    private String encrypted;

    /**
     * Format identifier ('raw', 'qcow2', 'subvol', 'iso', 'tgz' ...)
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * Optional notes. If they contain multiple lines, only the first one is returned here.
     * Type: string
     * Optional: True
     */
    @JsonProperty("notes")
    private String notes;

    /**
     * Volume identifier of parent (for linked cloned).
     * Type: string
     * Optional: True
     */
    @JsonProperty("parent")
    private String parent;

    /**
     * Protection status. Currently only supported for backups.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protected")
    private Boolean protectedValue;

    /**
     * Volume size in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * Used space. Please note that most storage plugins do not report anything useful here.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("used")
    private Integer used;

    /**
     * Last backup verification result, only useful for PBS storages.
     * Type: object
     * Optional: True
     */
    @JsonProperty("verification")
    private Object verification;

    /**
     * Associated Owner VMID.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vmid")
    private Integer vmId;

    /**
     * Volume identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("volid")
    private String volId;


}
