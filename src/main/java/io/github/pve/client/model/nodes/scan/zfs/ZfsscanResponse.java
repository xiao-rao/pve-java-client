package io.github.pve.client.model.nodes.scan.zfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Scan zfs pool list on local node.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZfsscanResponse {

    /**
     * ZFS pool name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool")
    private String pool;


}
