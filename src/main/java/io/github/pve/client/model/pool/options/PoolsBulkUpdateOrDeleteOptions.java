package io.github.pve.client.model.pool.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * 批量更新或删除资源池时的参数选项。
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolsBulkUpdateOrDeleteOptions {
    private String pools; // Comma-separated list of pool IDs to act on.
    // For PUT
    private String storage;
    private String vms;
    private Boolean delete;
}
