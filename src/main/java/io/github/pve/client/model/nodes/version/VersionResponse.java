package io.github.pve.client.model.nodes.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * API version details
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionResponse {

    /**
     * The current installed Proxmox VE Release
     * Type: string
     * Optional: True
     */
    @JsonProperty("release")
    private String release;

    /**
     * The short git commit hash ID from which this version was build
     * Type: string
     * Optional: True
     */
    @JsonProperty("repoid")
    private String repoId;

    /**
     * The current installed pve-manager package version
     * Type: string
     * Optional: True
     */
    @JsonProperty("version")
    private String version;


}
