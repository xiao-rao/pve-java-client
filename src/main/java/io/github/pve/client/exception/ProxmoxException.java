package io.github.pve.client.exception;

import java.io.IOException;

/**
 * Proxmox API客户端基础异常类
 */
public class ProxmoxException extends IOException {
    public ProxmoxException(String message) {
        super(message);
    }

    public ProxmoxException(String message, Throwable cause) {
        super(message, cause);
    }
}
