package io.github.pve.client.exception;

import lombok.Getter;

/**
 * Proxmox认证异常
 */
@Getter
public class ProxmoxAuthException extends ProxmoxException {
    private final int statusCode; // HTTP状态码，如果适用

    public ProxmoxAuthException(String message) {
        super(message);
        this.statusCode = -1;
    }
    public ProxmoxAuthException(String message, int statusCode) {
        super(message + " (Status: " + statusCode + ")");
        this.statusCode = statusCode;
    }

    public ProxmoxAuthException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
    }

}