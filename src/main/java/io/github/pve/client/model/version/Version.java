package io.github.pve.client.model.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Version {
    private String version;
    @JsonProperty("repoid")
    private String repoId;
    private String release;
}
