package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketCreationOptions {
    private String username;
    private String password;
    private String realm;
    private String path;
    @JsonProperty("new-password")
    private String newPassword;
    private String otp;
    @JsonProperty("tfa-challenge")
    private String tfaChallenge;
}

