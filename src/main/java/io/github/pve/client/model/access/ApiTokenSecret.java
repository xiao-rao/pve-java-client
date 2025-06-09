package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiTokenSecret {

    @JsonProperty("full-tokenid")
    private String fullTokenId;

    private String value; // The secret token value
}

