package io.github.pve.client.model.nodes.hardware.usb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List local USB devices.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsbscanResponse {

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("busnum")
    private Integer busnum;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("class")
    private Integer classValue;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("devnum")
    private Integer devnum;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("level")
    private Integer level;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("manufacturer")
    private String manufacturer;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("prodid")
    private String prodid;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("product")
    private String product;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("serial")
    private String serial;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("speed")
    private String speed;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("usbpath")
    private String usbpath;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("vendid")
    private String vendid;


}
