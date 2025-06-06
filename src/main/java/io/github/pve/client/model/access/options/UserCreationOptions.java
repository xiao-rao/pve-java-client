package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建或更新用户时的参数选项
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreationOptions {
    // Note: userid is part of the path, not the body, for create/update.

    private String password; // Only for creation

    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    private Long expire; // 0 for disabled

    private Integer enable; // 1 for enabled, 0 for disabled

    private String comment;

    /**
     * A list of group IDs to which this user should belong.
     */
    private String groups; // comma-separated list of group IDs
}

