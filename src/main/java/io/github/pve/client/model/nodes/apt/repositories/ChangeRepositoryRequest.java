package io.github.pve.client.model.nodes.apt.repositories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Change the properties of a repository. Currently only allows enabling/disabling.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeRepositoryRequest {

    /**
     * Digest to detect modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=80, message="Parameter 'digest' length must not exceed 80")
    @JsonProperty("digest")
    private String digest;

    /**
     * Whether the repository should be enabled or not.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * Index within the file (starting from 0).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("index")
    private Integer index;

    /**
     * Path to the containing file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;


}
