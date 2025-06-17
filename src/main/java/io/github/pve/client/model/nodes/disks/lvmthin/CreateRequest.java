package io.github.pve.client.model.nodes.disks.lvmthin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create an LVM thinpool
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Configure storage using the thinpool.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("add_storage")
    private Boolean addStorage;

    /**
     * The block device you want to create the thinpool on.
     * Type: string
     * Optional: True
     */
    @JsonProperty("device")
    private String device;

    /**
     * The storage identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
