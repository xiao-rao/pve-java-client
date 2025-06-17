package io.github.pve.client.model.nodes.hardware.pci;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List local PCI devices.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PciScanResponse {

    /**
     * The PCI Class of the device.
     * Type: string
     * Optional: True
     */
    @JsonProperty("class")
    private String classValue;

    /**
     * The Device ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("device")
    private String device;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("device_name")
    private String deviceName;

    /**
     * The PCI ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * The IOMMU group in which the device is in. If no IOMMU group is detected, it is set to -1.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("iommugroup")
    private Integer iommugroup;

    /**
     * If set, marks that the device is capable of creating mediated devices.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("mdev")
    private Boolean mdev;

    /**
     * The Subsystem Device ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("subsystem_device")
    private String subsystemDevice;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("subsystem_device_name")
    private String subsystemDeviceName;

    /**
     * The Subsystem Vendor ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("subsystem_vendor")
    private String subsystemVendor;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("subsystem_vendor_name")
    private String subsystemVendorName;

    /**
     * The Vendor ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vendor")
    private String vendor;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("vendor_name")
    private String vendorName;


}
