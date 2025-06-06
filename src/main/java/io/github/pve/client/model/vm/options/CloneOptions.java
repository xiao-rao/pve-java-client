package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloneOptions {
    @JsonProperty("newid")
    private Integer newid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full")
    private Boolean full; // Full clone (1) or linked clone (0)
    @JsonProperty("storage")
    private String storage;
    @JsonProperty("target")
    private String targetNode;
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("description")
    private String description;
}
