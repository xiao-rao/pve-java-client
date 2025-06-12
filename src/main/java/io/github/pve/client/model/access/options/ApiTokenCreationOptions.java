package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiTokenCreationOptions {

    @NotBlank
    @JsonProperty("userid")
    private String userId;

    @NotBlank
    @JsonProperty("tokenid")
    private String tokenId;

    private String comment;
    private Long expire; // 0 for no expiration
    @JsonProperty("privsep")
    private String privileges; // Comma-separated list of privileges
}
