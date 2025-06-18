package io.github.pve.client.model.nodes.time;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read server time and time zone settings.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeResponse {

    /**
     * Seconds since 1970-01-01 00:00:00 (local time)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("localtime")
    private Integer localtime;

    /**
     * Seconds since 1970-01-01 00:00:00 UTC.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("time")
    private Integer time;

    /**
     * Time zone
     * Type: string
     * Optional: True
     */
    @JsonProperty("timezone")
    private String timezone;


}
