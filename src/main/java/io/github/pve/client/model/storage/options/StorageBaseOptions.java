package io.github.pve.client.model.storage.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 存储公共参数基类（POST/PUT通用，除storage、type等专有参数外，约47个）
 * 参数注释详见Proxmox官方API文档：https://pve.proxmox.com/pve-docs/api-viewer/index.html#/storage
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageBaseOptions {
    /** 存储内容类型（如images,iso,backup等） */
    @JsonProperty("content")
    private String content;
    /** 允许使用该存储的节点列表（逗号分隔） */
    @JsonProperty("nodes")
    private String nodes;
    /** 是否禁用该存储 */
    @JsonProperty("disable")
    private Boolean disable;
    /** 最大受保护备份数 */
    @JsonProperty("max-protected-backups")
    private Integer maxProtectedBackups;
    /** 配置摘要（用于并发控制） */
    @JsonProperty("digest")
    private String digest;
    /** 目录路径（如dir/btrfs类型） */
    @JsonProperty("path")
    private String path;
    /** 预分配策略（off, metadata, falloc, full） */
    @JsonProperty("preallocation")
    private String preallocation;
    /** LVM卷组名 */
    @JsonProperty("vgname")
    private String vgName;
    /** LVM-thin池名 */
    @JsonProperty("thinpool")
    private String thinPool;
    /** 池名（ZFS/Ceph等） */
    @JsonProperty("pool")
    private String pool;
    /** 块大小 */
    @JsonProperty("blocksize")
    private String blockSize;
    /** 是否稀疏分配 */
    @JsonProperty("sparse")
    private Boolean sparse;
    /** 禁用写缓存 */
    @JsonProperty("nowritecache")
    private Boolean noWriteCache;
    /** 挂载点 */
    @JsonProperty("mountpoint")
    private String zfsMountPoint;
    /** 是否为挂载点 */
    @JsonProperty("is_mountpoint")
    private Boolean isMountpoint;
    /** iSCSI门户 */
    @JsonProperty("portal")
    private String portal;
    /** iSCSI目标 */
    @JsonProperty("target")
    private String target;
    /** iSCSI提供者 */
    @JsonProperty("iscsiprovider")
    private String iscsiProvider;
    /** Solaris Comstar host group */
    @JsonProperty("comstar_hg")
    private String comstarHg;
    /** Solaris Comstar target group */
    @JsonProperty("comstar_tg")
    private String comstarTg;
    /** LIO target portal group */
    @JsonProperty("lio_tpg")
    private String lioTpg;
    /** NFS/CIFS/GlusterFS服务器 */
    @JsonProperty("server")
    private String server;
    /** NFS导出路径 */
    @JsonProperty("export")
    private String export;
    /** NFS挂载选项 */
    @JsonProperty("options")
    private String nfsOptions;
    /** 最大文件数 */
    @JsonProperty("max-files")
    private Integer maxFiles;
    /** NFS版本 */
    @JsonProperty("nfsversion")
    private String nfsVersion;
    /** 本地路径 */
    @JsonProperty("local-path")
    private String localPath;
    /** CIFS共享名 */
    @JsonProperty("share")
    private String share;
    /** 用户名（CIFS/Ceph/PBS等） */
    @JsonProperty("username")
    private String username;
    /** 密码（CIFS/Ceph/PBS等） */
    @JsonProperty("password")
    private String password;
    /** SMB版本 */
    @JsonProperty("smbversion")
    private String smbVersion;
    /** 域名 */
    @JsonProperty("domain")
    private String domain;
    /** Ceph监控主机 */
    @JsonProperty("monhost")
    private String monHost;
    /** Ceph认证组 */
    @JsonProperty("authgroup")
    private String authGroup;
    /** Ceph密钥环 */
    @JsonProperty("keyring")
    private String keyring;
    /** 是否使用krbd */
    @JsonProperty("krbd")
    private Boolean krbd;
    /** PBS数据存储名 */
    @JsonProperty("datastore")
    private String datastore;
    /** PBS命名空间 */
    @JsonProperty("namespace")
    private String namespace;
    /** PBS API Token */
    @JsonProperty("api-token")
    private String apiTokenSecret;
    /** PBS加密密钥 */
    @JsonProperty("encryption-key")
    private String encryptionKey;
    /** PBS指纹 */
    @JsonProperty("fingerprint")
    private String fingerprint;
    /** PBS主公钥 */
    @JsonProperty("master-pubkey")
    private String masterPubkey;
    /** GlusterFS服务器 */
    @JsonProperty("glusterfsServer")
    private String glusterfsServer;
    /** GlusterFS第二服务器 */
    @JsonProperty("server2")
    private String glusterfsServer2;
    /** GlusterFS传输类型 */
    @JsonProperty("transport")
    private String transport;
    /** GlusterFS卷名 */
    @JsonProperty("volume")
    private String volume;
} 