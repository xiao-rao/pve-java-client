package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenIdLoginOptions {
    private String code;
    private String redirect_uri;
    private String state;
}

