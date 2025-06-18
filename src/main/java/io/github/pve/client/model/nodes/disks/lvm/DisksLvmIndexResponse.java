package io.github.pve.client.model.nodes.disks.lvm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List LVM Volume Groups
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisksLvmIndexResponse {

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("children")
    private List<Object> children;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("leaf")
    private Boolean leaf;


}
