package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiToken {
    @JsonProperty("tokenid")
    private String tokenId;

    private String comment;

    private Long expire;

    private Integer privsep; // Not a list of strings, but an integer flag in this context
}
