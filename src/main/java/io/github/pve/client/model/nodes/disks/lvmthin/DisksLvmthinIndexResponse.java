package io.github.pve.client.model.nodes.disks.lvmthin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List LVM thinpools
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisksLvmthinIndexResponse {

    /**
     * The name of the thinpool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("lv")
    private String lv;

    /**
     * The size of the thinpool in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("lv_size")
    private Integer lvSize;

    /**
     * The size of the metadata lv in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("metadata_size")
    private Integer metadataSize;

    /**
     * The used bytes of the metadata lv.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("metadata_used")
    private Integer metadataUsed;

    /**
     * The used bytes of the thinpool.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("used")
    private Integer used;

    /**
     * The associated volume group.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vg")
    private String vg;


}
