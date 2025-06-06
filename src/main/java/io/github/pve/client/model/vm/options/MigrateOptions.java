package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateOptions {
    private String target; // Target node name
    private Integer online; // Use 1 for live migration
    private Integer withLocalDisks;
    // ... other migration options
}
