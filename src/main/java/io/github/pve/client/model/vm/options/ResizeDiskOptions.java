package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResizeDiskOptions {
    private String disk; // e.g., "scsi0", "virtio1"
    private String size; // e.g., "+10G", "20G"
}