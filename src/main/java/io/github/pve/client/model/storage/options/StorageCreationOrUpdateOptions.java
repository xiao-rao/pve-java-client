package io.github.pve.client.model.storage.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建或更新存储时的参数选项。
 */
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageCreationOrUpdateOptions {
    // --- General ---
    @JsonProperty("type")
    private String type; // Required for POST
    @JsonProperty("content")
    private String content;
    @JsonProperty("nodes")
    private String nodes; // Comma-separated list of node names
    @JsonProperty("disable")
    private Boolean disable;
    @JsonProperty("max-protected-backups")
    private Integer maxProtectedBackups;
    @JsonProperty("digest")
    private String digest; // For update validation

    // --- Directory & BTRFS ---
    @JsonProperty("path")
    private String path;
    @JsonProperty("preallocation")
    private String preallocation; // "off", "metadata", "falloc", "full"

    // --- LVM & LVM-thin ---
    @JsonProperty("vgname")
    private String vgName;
    @JsonProperty("thinpool")
    private String thinPool;
    @JsonProperty("content-type")
    private String lvmContentType; // for LVM

    // --- ZFS & ZFS-over-iSCSI ---
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("blocksize")
    private String blockSize;
    @JsonProperty("sparse")
    private Boolean sparse;
    @JsonProperty("nowritecache")
    private Boolean noWriteCache;
    @JsonProperty("mountpoint")
    private String zfsMountPoint;
    @JsonProperty("is_mountpoint")
    private Boolean isMountpoint;

    // --- iSCSI ---
    @JsonProperty("portal")
    private String portal;
    @JsonProperty("target")
    private String target;
    @JsonProperty("iscsiprovider")
    private String iscsiProvider;

    // --- iSCSI (Solaris Comstar) ---
    @JsonProperty("comstar_hg")
    private String comstarHg;
    @JsonProperty("comstar_tg")
    private String comstarTg;

    // --- iSCSI (LIO) ---
    @JsonProperty("lio_tpg")
    private String lioTpg;

    // --- NFS ---
    @JsonProperty("server")
    private String server;
    @JsonProperty("export")
    private String export;
    @JsonProperty("options")
    private String nfsOptions;
    @JsonProperty("max-files")
    private Integer maxFiles;
    @JsonProperty("nfsversion")
    private String nfsVersion;
    @JsonProperty("local-path")
    private String localPath;

    // --- CIFS ---
    // Shares 'server' and 'max-files' with NFS
    @JsonProperty("share")
    private String share;
    @JsonProperty("username")
    private String username; // Also used for Ceph and PBS
    @JsonProperty("password")
    private String password; // Also used for Ceph and PBS
    @JsonProperty("smbversion")
    private String smbVersion;
    @JsonProperty("domain")
    private String domain;

    // --- Ceph / RBD ---
    @JsonProperty("monhost")
    private String monHost; // Comma-separated list of monitor hosts
    @JsonProperty("authgroup")
    private String authGroup;
    @JsonProperty("keyring")
    private String keyring;
    @JsonProperty("krbd")
    private Boolean krbd;
    // Shares 'pool' and 'username' with other types

    // --- Proxmox Backup Server (PBS) ---
    // Shares 'server' and 'username' with other types
    @JsonProperty("datastore")
    private String datastore;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("api-token")
    private String apiTokenSecret; // Re-using 'password' field in client, but API uses 'api-token'
    @JsonProperty("encryption-key")
    private String encryptionKey;
    @JsonProperty("fingerprint")
    private String fingerprint;
    @JsonProperty("master-pubkey")
    private String masterPubkey;

    // --- GlusterFS ---
    @JsonProperty("server")
    private String glusterfsServer; // Re-using server field
    @JsonProperty("server2")
    private String glusterfsServer2;
    @JsonProperty("transport")
    private String transport;
    @JsonProperty("volume")
    private String volume;
}