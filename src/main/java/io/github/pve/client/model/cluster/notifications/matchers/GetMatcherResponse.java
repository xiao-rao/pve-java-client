package io.github.pve.client.model.cluster.notifications.matchers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Return a specific matcher
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMatcherResponse {

    /**
     * Comment
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
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
     * Name of the matcher.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Targets to notify on match
     * Type: array
     * Optional: True
     */
    @JsonProperty("target")
    private List<String> target;


}
