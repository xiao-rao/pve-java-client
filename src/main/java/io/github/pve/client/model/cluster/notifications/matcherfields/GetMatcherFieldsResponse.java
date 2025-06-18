package io.github.pve.client.model.cluster.notifications.matcherfields;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Returns known notification metadata fields
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMatcherFieldsResponse {

    /**
     * Name of the field.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
