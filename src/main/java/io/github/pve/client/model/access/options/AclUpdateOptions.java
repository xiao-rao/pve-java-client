package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AclUpdateOptions {
    @NotBlank
    private String path; // The path to set the ACL on
    @NotBlank
    private String roles; // Role ID to grant
    private String users; // Comma-separated list of users
    private String groups; // Comma-separated list of groups
    private String tokens; // Comma-separated list of API tokens
    @JsonProperty("delete")
    private Integer delete; // Use 1 to delete the specified permissions
    private Integer propagate; // Use 1 to propagate permissions
}
