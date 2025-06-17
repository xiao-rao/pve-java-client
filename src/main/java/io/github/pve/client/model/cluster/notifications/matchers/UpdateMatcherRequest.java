package io.github.pve.client.model.cluster.notifications.matchers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update existing matcher
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateMatcherRequest {

    /**
     * Comment
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * A list of settings you want to delete.
     * Type: array
     * Optional: True
     */
    @JsonProperty("delete")
    private List<String> delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Disable this matcher
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * Invert match of the whole matcher
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("invert-match")
    private Boolean invertMatch;

    /**
     * Match notification timestamp
     * Type: array
     * Optional: True
     */
    @JsonProperty("match-calendar")
    private List<String> matchCalendar;

    /**
     * Metadata fields to match (regex or exact match). Must be in the form (regex|exact):<field>=<value>
     * Type: array
     * Optional: True
     */
    @JsonProperty("match-field")
    private List<String> matchField;

    /**
     * Notification severities to match
     * Type: array
     * Optional: True
     */
    @JsonProperty("match-severity")
    private List<String> matchSeverity;

    /**
     * Choose between 'all' and 'any' for when multiple properties are specified
     * Type: string
     * Optional: True
     */
    @JsonProperty("mode")
    private String mode;

    /**
     * Targets to notify on match
     * Type: array
     * Optional: True
     */
    @JsonProperty("target")
    private List<String> target;

    /**
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
