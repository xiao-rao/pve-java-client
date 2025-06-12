package io.github.pve.client.exception;


/**
 * Proxmox API客户端基础异常类
 * 继承自RuntimeException，使其成为非受检异常，以简化客户端方法签名。
 */
public class ProxmoxException extends RuntimeException {


    public ProxmoxException(String message) {
        super(message);
    }

    public ProxmoxException(String message, Throwable cause) {
        super(message, cause);
    }
}
