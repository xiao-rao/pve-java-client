package io.github.pve.client.model.nodes.scan.lvmthin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List local LVM Thin Pools.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LvmthinscanResponse {

    /**
     * The LVM Thin Pool name (LVM logical volume).
     * Type: string
     * Optional: True
     */
    @JsonProperty("lv")
    private String lv;


}
