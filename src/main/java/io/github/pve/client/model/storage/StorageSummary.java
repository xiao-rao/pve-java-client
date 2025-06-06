package io.github.pve.client.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 存储摘要信息
 * Corresponds to an item in the response from GET /nodes/{node}/storage or GET /storage
 */
@Data
public class StorageSummary {

    /**
     * The storage identifier.
     */
    private String storage;

    /**
     * Storage type.
     */
    private String type;

    /**
     * A list of content types that can be stored on this storage.
     */
    private String content;

    /**
     * Set when storage is online.
     */
    @JsonProperty("active")
    private Integer active;

    /**
     * Set when storage is enabled.
     */
    private Integer enabled;

    /**
     * Total space in bytes.
     */
    private Long total;

    /**
     * Used space in bytes.
     */
    private Long used;

    /**
     * Available space in bytes.
     */
    private Long avail;

    /**
     * Is the storage shared between nodes.
     */
    private Integer shared;

    /**
     * For internal use, to detect if the storage is usable.
     */
    @JsonProperty("used_fraction")
    private Double usedFraction;

    /**
     * The path to the storage.
     */
    private String path;

    /**
     * The pool name for ZFS, CEPH, etc.
     */
    private String pool;
}

