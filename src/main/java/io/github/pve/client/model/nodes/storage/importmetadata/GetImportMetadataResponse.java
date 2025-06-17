package io.github.pve.client.model.nodes.storage.importmetadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Get the base parameters for creating a guest which imports data from a foreign importable guest, like an ESXi VM
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetImportMetadataResponse {

    /**
     * Parameters which can be used in a call to create a VM or container.
     * Type: object
     * Optional: True
     */
    @JsonProperty("create-args")
    private Map<String, Object> createArgs;

    /**
     * Recognised disk volumes as `$bus$id` => `$storeid:$path` map.
     * Type: object
     * Optional: True
     */
    @JsonProperty("disks")
    private Map<String, Object> disks;

    /**
     * Recognised network interfaces as `net$id` => { ...params } object.
     * Type: object
     * Optional: True
     */
    @JsonProperty("net")
    private Map<String, Object> net;

    /**
     * The type of the import-source of this guest volume.
     * Type: string
     * Optional: True
     */
    @JsonProperty("source")
    private String source;

    /**
     * The type of guest this is going to produce.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * List of known issues that can affect the import of a guest. Note that lack of warning does not imply that there cannot be any problems.
     * Type: array
     * Optional: True
     */
    @JsonProperty("warnings")
    private List<Object> warnings;


}
