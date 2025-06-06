package io.github.pve.client.config;


import java.util.Objects;

/**
 * Proxmox VE节点连接的核心配置
 *
 * @param nodeId               节点的唯一标识符，用于缓存等
 * @param apiUrl               PVE API基础URL, e.g., "https://pve.example.com:8006/api2/json"
 * @param trustSelfSignedCerts 是否信任自签名SSL证书
 */
public record NodeConnectionConfig(String nodeId, String apiUrl, boolean trustSelfSignedCerts) {

    public NodeConnectionConfig(String nodeId, String apiUrl, boolean trustSelfSignedCerts) {
        if (nodeId == null || nodeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Node ID cannot be null or empty.");
        }
        if (apiUrl == null || !apiUrl.matches("https://.*")) {
            throw new IllegalArgumentException("API URL must be a valid HTTPS URL.");
        }
        this.nodeId = nodeId;
        // 确保API URL以 /api2/json 结尾，并且不含末尾的 /
        String normalizedApiUrl = apiUrl.trim();
        if (normalizedApiUrl.endsWith("/")) {
            normalizedApiUrl = normalizedApiUrl.substring(0, normalizedApiUrl.length() - 1);
        }
        if (!normalizedApiUrl.endsWith("/api2/json")) {
            if (normalizedApiUrl.endsWith("/api2")) {
                normalizedApiUrl += "/json";
            } else {
                normalizedApiUrl += "/api2/json";
            }
        }
        this.apiUrl = normalizedApiUrl;
        this.trustSelfSignedCerts = trustSelfSignedCerts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeConnectionConfig that = (NodeConnectionConfig) o;
        return nodeId.equals(that.nodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId);
    }

    @Override
    public String toString() {
        return "NodeConnectionConfig{" +
                "nodeId='" + nodeId + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", trustSelfSignedCerts=" + trustSelfSignedCerts +
                '}';
    }
}