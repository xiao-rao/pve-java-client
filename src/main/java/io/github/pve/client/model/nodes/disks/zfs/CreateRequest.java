package io.github.pve.client.model.nodes.disks.zfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create a ZFS pool.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Configure storage using the zpool.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("add_storage")
    private Boolean addStorage;

    /**
     * Pool sector size exponent.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ashift")
    private Integer ashift;

    /**
     * The compression algorithm to use.
     * Type: string
     * Optional: True
     */
    @JsonProperty("compression")
    private String compression;

    /**
     * The block devices you want to create the zpool on.
     * Type: string
     * Optional: True
     */
    @JsonProperty("devices")
    private String devices;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("draid-config")
    private String draIdConfig;

    /**
     * The storage identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * The RAID level to use.
     * Type: string
     * Optional: True
     */
    @JsonProperty("raidlevel")
    private String raidlevel;


}
