package io.github.pve.client.model.nodes.ceph.osd.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get OSD details
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OsddetailsResponse {

    /**
     * Array containing data about devices
     * Type: array
     * Optional: True
     */
    @JsonProperty("devices")
    private List<Object> devices;

    /**
     * General information about the OSD
     * Type: object
     * Optional: True
     */
    @JsonProperty("osd")
    private Object osd;


}
