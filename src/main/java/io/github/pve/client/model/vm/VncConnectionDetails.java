package io.github.pve.client.model.vm;

import lombok.Data;

/**
 * VNC/SPICE 控制台连接详情
 * Corresponds to response from POST /nodes/{node}/qemu/{vmid}/vncproxy
 */
@Data
public class VncConnectionDetails {
    private String cert;
    private Integer port;
    private String ticket;
    private String user;
    private String upid;
    private String type; // "vnc", "spice"
}
