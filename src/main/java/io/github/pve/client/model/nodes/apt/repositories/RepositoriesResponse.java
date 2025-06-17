package io.github.pve.client.model.nodes.apt.repositories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get APT repository information.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepositoriesResponse {

    /**
     * Common digest of all files.
     * Type: string
     * Optional: True
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * List of problematic repository files.
     * Type: array
     * Optional: True
     */
    @JsonProperty("errors")
    private List<Object> errors;

    /**
     * List of parsed repository files.
     * Type: array
     * Optional: True
     */
    @JsonProperty("files")
    private List<Object> files;

    /**
     * Additional information/warnings for APT repositories.
     * Type: array
     * Optional: True
     */
    @JsonProperty("infos")
    private List<Object> infos;

    /**
     * List of standard repositories and their configuration status
     * Type: array
     * Optional: True
     */
    @JsonProperty("standard-repos")
    private List<Object> standardRepos;


}
