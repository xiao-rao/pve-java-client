package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 * 创建或更新用户时的参数选项
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreationOrUpdateOptions {
    // Note: userid is part of the path, not the body, for create/update.

    @NotBlank
    @JsonProperty("userid")
    private String userId;

    private String password; // Only for creation

    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    private Long expire; // 0 for disabled

    private final Integer enable = 1; // 1 for enabled, 0 for disabled

    private String comment;

    /**
     * A list of group IDs to which this user should belong.
     */
    private String groups; // comma-separated list of group IDs

    private String keys; // For two-factor auth (Yubico)

}

