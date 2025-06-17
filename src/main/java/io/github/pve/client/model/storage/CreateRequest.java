package io.github.pve.client.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Create a new storage.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Authsupported.
     * Type: string
     * Optional: True
     */
    @JsonProperty("authsupported")
    private String authsupported;

    /**
     * Base volume. This volume is automatically activated.
     * Type: string
     * Optional: True
     */
    @JsonProperty("base")
    private String base;

    /**
     * block size
     * Type: string
     * Optional: True
     */
    @JsonProperty("blocksize")
    private String blocksize;

    /**
     * Set I/O bandwidth limit for various operations (in KiB/s).
     * Type: string
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private String bwlimit;

    /**
     * host group for comstar views
     * Type: string
     * Optional: True
     */
    @JsonProperty("comstar_hg")
    private String comstarHg;

    /**
     * target group for comstar views
     * Type: string
     * Optional: True
     */
    @JsonProperty("comstar_tg")
    private String comstarTg;

    /**
     * Allowed content types.  NOTE: the value 'rootdir' is used for Containers, and value 'images' for VMs. 
     * Type: string
     * Optional: True
     */
    @JsonProperty("content")
    private String content;

    /**
     * Overrides for default content type directories.
     * Type: string
     * Optional: True
     */
    @JsonProperty("content-dirs")
    private String contentDirs;

    /**
     * Create the base directory if it doesn't exist.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("create-base-path")
    private Boolean createBasePath;

    /**
     * Populate the directory with the default structure.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("create-subdirs")
    private Boolean createSubdirs;

    /**
     * Data Pool (for erasure coding only)
     * Type: string
     * Optional: True
     */
    @JsonProperty("data-pool")
    private String dataPool;

    /**
     * Proxmox Backup Server datastore name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("datastore")
    private String datastore;

    /**
     * Flag to disable the storage.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * CIFS domain.
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'domain' length must not exceed 256")
    @JsonProperty("domain")
    private String domain;

    /**
     * Encryption key. Use 'autogen' to generate one automatically without passphrase.
     * Type: string
     * Optional: True
     */
    @JsonProperty("encryption-key")
    private String encryptionKey;

    /**
     * NFS export path.
     * Type: string
     * Optional: True
     */
    @JsonProperty("export")
    private String export;

    /**
     * Certificate SHA 256 fingerprint.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="([A-Fa-f0-9]{2}:){31}[A-Fa-f0-9]{2}", message="Parameter 'fingerprint' does not match pattern")
    @JsonProperty("fingerprint")
    private String fingerprint;

    /**
     * Default image format.
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * The Ceph filesystem name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("fs-name")
    private String fsName;

    /**
     * Mount CephFS through FUSE.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("fuse")
    private Boolean fuse;

    /**
     * Assume the given path is an externally managed mountpoint and consider the storage offline if it is not mounted. Using a boolean (yes/no) value serves as a shortcut to using the target path in this field.
     * Type: string
     * Optional: True
     */
    @JsonProperty("is_mountpoint")
    private String isMountpoint;

    /**
     * iscsi provider
     * Type: string
     * Optional: True
     */
    @JsonProperty("iscsiprovider")
    private String iscsiprovider;

    /**
     * Client keyring contents (for external clusters).
     * Type: string
     * Optional: True
     */
    @JsonProperty("keyring")
    private String keyring;

    /**
     * Always access rbd through krbd kernel module.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("krbd")
    private Boolean krbd;

    /**
     * target portal group for Linux LIO targets
     * Type: string
     * Optional: True
     */
    @JsonProperty("lio_tpg")
    private String lioTpg;

    /**
     * Base64-encoded, PEM-formatted public RSA key. Used to encrypt a copy of the encryption-key which will be added to each encrypted backup.
     * Type: string
     * Optional: True
     */
    @JsonProperty("master-pubkey")
    private String masterPubkey;

    /**
     * Maximal number of protected backups per guest. Use '-1' for unlimited.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max-protected-backups")
    private Integer maxProtectedBackups;

    /**
     * Deprecated: use 'prune-backups' instead. Maximal number of backup files per VM. Use '0' for unlimited.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxfiles")
    private Integer maxfiles;

    /**
     * Create the directory if it doesn't exist and populate it with default sub-dirs. NOTE: Deprecated, use the 'create-base-path' and 'create-subdirs' options instead.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("mkdir")
    private Boolean mkdir;

    /**
     * IP addresses of monitors (for external clusters).
     * Type: string
     * Optional: True
     */
    @JsonProperty("monhost")
    private String monhost;

    /**
     * mount point
     * Type: string
     * Optional: True
     */
    @JsonProperty("mountpoint")
    private String mountpoint;

    /**
     * Namespace.
     * Type: string
     * Optional: True
     */
    @JsonProperty("namespace")
    private String namespace;

    /**
     * Set the NOCOW flag on files. Disables data checksumming and causes data errors to be unrecoverable from while allowing direct I/O. Only use this if data does not need to be any more safe than on a single ext4 formatted disk with no underlying raid system.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nocow")
    private Boolean nocow;

    /**
     * List of nodes for which the storage configuration applies.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nodes")
    private String nodes;

    /**
     * disable write caching on the target
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nowritecache")
    private Boolean nowritecache;

    /**
     * NFS/CIFS mount options (see 'man nfs' or 'man mount.cifs')
     * Type: string
     * Optional: True
     */
    @JsonProperty("options")
    private String options;

    /**
     * Password for accessing the share/datastore.
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'password' length must not exceed 256")
    @JsonProperty("password")
    private String password;

    /**
     * File system path.
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;

    /**
     * Pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool")
    private String pool;

    /**
     * Use this port to connect to the storage instead of the default one (for example, with PBS or ESXi). For NFS and CIFS, use the 'options' option to configure the port via the mount options.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * iSCSI portal (IP or DNS name with optional port).
     * Type: string
     * Optional: True
     */
    @JsonProperty("portal")
    private String portal;

    /**
     * Preallocation mode for raw and qcow2 images. Using 'metadata' on raw images results in preallocation=off.
     * Type: string
     * Optional: True
     */
    @JsonProperty("preallocation")
    private String preallocation;

    /**
     * The retention options with shorter intervals are processed first with --keep-last being the very first one. Each option covers a specific period of time. We say that backups within this period are covered by this option. The next option does not take care of already covered backups and only considers older backups.
     * Type: string
     * Optional: True
     */
    @JsonProperty("prune-backups")
    private String pruneBackups;

    /**
     * Zero-out data when removing LVs.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("saferemove")
    private Boolean saferemove;

    /**
     * Wipe throughput (cstream -t parameter value).
     * Type: string
     * Optional: True
     */
    @JsonProperty("saferemove_throughput")
    private String saferemoveThroughput;

    /**
     * Server IP or DNS name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;

    /**
     * Backup volfile server IP or DNS name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("server2")
    private String server2;

    /**
     * CIFS share.
     * Type: string
     * Optional: True
     */
    @JsonProperty("share")
    private String share;

    /**
     * Indicate that this is a single storage with the same contents on all nodes (or all listed in the 'nodes' option). It will not make the contents of a local storage automatically accessible to other nodes, it just marks an already shared storage as such!
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("shared")
    private Boolean shared;

    /**
     * Disable TLS certificate verification, only enable on fully trusted networks!
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skip-cert-verification")
    private Boolean skipCertVerification;

    /**
     * SMB protocol version. 'default' if not set, negotiates the highest SMB2+ version supported by both the client and server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("smbversion")
    private String smbversion;

    /**
     * use sparse volumes
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("sparse")
    private Boolean sparse;

    /**
     * The storage identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * Subdir to mount.
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;

    /**
     * Only use logical volumes tagged with 'pve-vm-ID'.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("tagged_only")
    private Boolean taggedOnly;

    /**
     * iSCSI target.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target")
    private String target;

    /**
     * LVM thin pool LV name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("thinpool")
    private String thinpool;

    /**
     * Gluster transport: tcp or rdma
     * Type: string
     * Optional: True
     */
    @JsonProperty("transport")
    private String transport;

    /**
     * Storage type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * RBD Id.
     * Type: string
     * Optional: True
     */
    @JsonProperty("username")
    private String username;

    /**
     * Volume group name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vgname")
    private String vgname;

    /**
     * Glusterfs Volume.
     * Type: string
     * Optional: True
     */
    @JsonProperty("volume")
    private String volume;


}
