package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupCreationOrUpdateOptions {
    private String comment;
    // For PUT only, to update members
    private String members; // Comma-separated list of user IDs
}
