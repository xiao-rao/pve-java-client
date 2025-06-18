package io.github.pve.client.model.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * API version details, including some parts of the global datacenter config.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionResponse {

    /**
     * The default console viewer to use.
     * Type: string
     * Optional: True
     */
    @JsonProperty("console")
    private String console;

    /**
     * The current Proxmox VE point release in `x.y` format.
     * Type: string
     * Optional: True
     */
    @JsonProperty("release")
    private String release;

    /**
     * The short git revision from which this version was build.
     * Type: string
     * Optional: True
     */
    @JsonProperty("repoid")
    private String repoId;

    /**
     * The full pve-manager package version of this node.
     * Type: string
     * Optional: True
     */
    @JsonProperty("version")
    private String version;


}
