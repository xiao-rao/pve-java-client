package io.github.pve.client.model.cluster.metrics.export;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Retrieve metrics of the cluster.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExportResponse {

    /**
     * Array of system metrics. Metrics are sorted by their timestamp.
     * Type: array
     * Optional: True
     */
    @JsonProperty("data")
    private List<Object> data;


}
