package io.github.pve.client.exception;

import lombok.Getter;

/**
 * Proxmox API调用通用异常
 */
@Getter
public class ProxmoxApiException extends ProxmoxException {
    private final int statusCode;
    private final String errorResponse;
    private final String pveNodeId;
    private final String apiEndpoint;

    public ProxmoxApiException(String message, int statusCode, String errorResponse, String pveNodeId, String apiEndpoint) {
        super(String.format("API call to '%s' on node '%s' failed: %s (Status: %d)",
                apiEndpoint, pveNodeId, message, statusCode));
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
        this.pveNodeId = pveNodeId;
        this.apiEndpoint = apiEndpoint;
    }

    public ProxmoxApiException(String message, Throwable cause, String pveNodeId, String apiEndpoint) {
        super(String.format("Exception during API call to '%s' on node '%s': %s",
                apiEndpoint, pveNodeId, message), cause);
        this.statusCode = -1;
        this.errorResponse = null;
        this.pveNodeId = pveNodeId;
        this.apiEndpoint = apiEndpoint;
    }


}

