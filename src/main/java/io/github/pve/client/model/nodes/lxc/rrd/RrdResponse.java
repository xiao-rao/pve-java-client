package io.github.pve.client.model.nodes.lxc.rrd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read VM RRD statistics (returns PNG)
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RrdResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("filename")
    private String filename;


}
