package io.github.pve.client.model.pool.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * 更新资源池时的参数选项
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolUpdateOptions {

    /**
     * A comment for the pool.
     */
    private String comment;

    /**
     * A list of VMIDs to add to the pool.
     */
    private String vms; // comma-separated list of VM IDs

    /**
     * A list of storage IDs to add to the pool.
     */
    private String storage; // comma-separated list of storage IDs

    /**
     * A list of VMIDs to remove from the pool.
     */
    private String deleteVms; // comma-separated list of VM IDs to delete

    /**
     * A list of storage IDs to remove from the pool.
     */
    private String deleteStorage; // comma-separated list of storage IDs to delete
}
