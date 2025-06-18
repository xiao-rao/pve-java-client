package io.github.pve.client.model.nodes.scan.lvm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List local LVM volume groups.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LvmscanResponse {

    /**
     * The LVM logical volume group name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vg")
    private String vg;


}
