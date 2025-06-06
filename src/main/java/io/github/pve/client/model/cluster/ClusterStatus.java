package io.github.pve.client.model.cluster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClusterStatus {
    private String id;
    private String name;
    private String type; // "node" or "quorum"
    private Integer local;
    private Integer nodeid;
    private Integer level;
    private String version;
    private String ip;
    private Integer online;
    @JsonProperty("quorate")
    private Integer quorate;
}
