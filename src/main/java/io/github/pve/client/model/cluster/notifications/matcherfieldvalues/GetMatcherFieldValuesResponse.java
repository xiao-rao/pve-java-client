package io.github.pve.client.model.cluster.notifications.matcherfieldvalues;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Returns known notification metadata fields and their known values
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMatcherFieldValuesResponse {

    /**
     * Additional comment for this value.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Field this value belongs to.
     * Type: string
     * Optional: True
     */
    @JsonProperty("field")
    private String field;

    /**
     * Notification metadata value known by the system.
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;


}
