package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthDomain {
    @JsonProperty("realm")
    private String realm;
    private String type;
    private String comment;
    private String tfa;
    @JsonProperty("default")
    private Integer isDefault;
}

