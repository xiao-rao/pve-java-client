package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 更新用户密码时的参数选项
 * Corresponds to parameters for PUT /access/password
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordUpdateOptions {
    /**
     * The user ID.
     */
    private String userid;

    /**
     * The new password.
     */
    private String password;

    @JsonProperty("confirmation-password")
    private String confirmationPassword;

}
