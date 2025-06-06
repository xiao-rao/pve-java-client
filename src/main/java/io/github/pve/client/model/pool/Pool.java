package io.github.pve.client.model.pool;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;;

/**
 * 资源池信息
 * Corresponds to an item in the response from GET /pools or GET /pools/{poolid}
 */
@Data
public class Pool {
    /**
     * The pool ID.
     */
    @JsonProperty("poolid")
    private String poolId;

    /**
     * A comment for the pool.
     */
    private String comment;

    /**
     * List of members in this pool.
     * Note: This field is only present when querying a specific pool (GET /pools/{poolid}).
     */
    private List<PoolMember> members;

    /**
     * Represents a member within a pool.
     */
    @Data
    public static class PoolMember {
        private String id;
        private String node;
        private Integer vmid;
        private String type; // "qemu" or "storage"
        private String storage;
        private String name; // for VMs
    }
}

