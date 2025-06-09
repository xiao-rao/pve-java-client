package io.github.pve.client.model.access;

import lombok.Data;
import java.util.Map;

/**
 * 用户在特定路径下的权限信息
 * Corresponds to the response from GET /access/permissions
 * The response is a JSON object where keys are privilege names and values are booleans (or integers 0/1).
 */
@Data
public class Permissions {
    /**
     * A map of privileges. The key is the privilege name (e.g., "VM.Allocate"),
     * and the value indicates if the permission is granted.
     */
    private Map<String, Boolean> privileges;
}

