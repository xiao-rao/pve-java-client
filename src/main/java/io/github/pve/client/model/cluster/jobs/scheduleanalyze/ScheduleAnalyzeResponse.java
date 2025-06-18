package io.github.pve.client.model.cluster.jobs.scheduleanalyze;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Returns a list of future schedule runtimes.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleAnalyzeResponse {

    /**
     * UNIX timestamp for the run.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timestamp")
    private Integer timestamp;

    /**
     * UTC timestamp for the run.
     * Type: string
     * Optional: True
     */
    @JsonProperty("utc")
    private String utc;


}
