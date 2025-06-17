package io.github.pve.client.model.nodes.ceph.osd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create OSD
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateosdRequest {

    /**
     * Set the device class of the OSD in crush.
     * Type: string
     * Optional: True
     */
    @JsonProperty("crush-device-class")
    private String crushDeviceClass;

    /**
     * Block device name for block.db.
     * Type: string
     * Optional: True
     */
    @JsonProperty("db_dev")
    private String dbDev;

    /**
     * Size in GiB for block.db.
     * Type: number
     * Optional: True
     */
    @JsonProperty("db_dev_size")
    private Double dbDevSize;

    /**
     * Block device name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dev")
    private String dev;

    /**
     * Enables encryption of the OSD.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("encrypted")
    private Boolean encrypted;

    /**
     * OSD services per physical device. Only useful for fast NVMe devices" 		    ." to utilize their performance better.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("osds-per-device")
    private Integer osdsPerDevice;

    /**
     * Block device name for block.wal.
     * Type: string
     * Optional: True
     */
    @JsonProperty("wal_dev")
    private String walDev;

    /**
     * Size in GiB for block.wal.
     * Type: number
     * Optional: True
     */
    @JsonProperty("wal_dev_size")
    private Double walDevSize;


}
