package io.github.pve.client.model.nodes.ceph.osd.lvinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get OSD volume details
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OsdvolumeResponse {

    /**
     * Creation time as reported by `lvs`.
     * Type: string
     * Optional: True
     */
    @JsonProperty("creation_time")
    private String creationTime;

    /**
     * Name of the logical volume (LV).
     * Type: string
     * Optional: True
     */
    @JsonProperty("lv_name")
    private String lvName;

    /**
     * Path to the logical volume (LV).
     * Type: string
     * Optional: True
     */
    @JsonProperty("lv_path")
    private String lvPath;

    /**
     * Size of the logical volume (LV).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("lv_size")
    private Integer lvSize;

    /**
     * UUID of the logical volume (LV).
     * Type: string
     * Optional: True
     */
    @JsonProperty("lv_uuid")
    private String lvUuId;

    /**
     * Name of the volume group (VG).
     * Type: string
     * Optional: True
     */
    @JsonProperty("vg_name")
    private String vgName;


}
