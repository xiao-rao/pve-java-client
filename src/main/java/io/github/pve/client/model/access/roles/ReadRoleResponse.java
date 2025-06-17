package io.github.pve.client.model.access.roles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get role configuration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadRoleResponse {

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Datastore.Allocate")
    private Boolean datastoreAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Datastore.AllocateSpace")
    private Boolean datastoreAllocatespace;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Datastore.AllocateTemplate")
    private Boolean datastoreAllocatetemplate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Datastore.Audit")
    private Boolean datastoreAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Group.Allocate")
    private Boolean groupAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Mapping.Audit")
    private Boolean mappingAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Mapping.Modify")
    private Boolean mappingModify;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Mapping.Use")
    private Boolean mappingUse;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Permissions.Modify")
    private Boolean permissionsModify;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Pool.Allocate")
    private Boolean poolAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Pool.Audit")
    private Boolean poolAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Realm.Allocate")
    private Boolean realmAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Realm.AllocateUser")
    private Boolean realmAllocateuser;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("SDN.Allocate")
    private Boolean sdnAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("SDN.Audit")
    private Boolean sdnAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("SDN.Use")
    private Boolean sdnUse;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.AccessNetwork")
    private Boolean sysAccessnetwork;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.Audit")
    private Boolean sysAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.Console")
    private Boolean sysConsole;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.Incoming")
    private Boolean sysIncoming;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.Modify")
    private Boolean sysModify;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.PowerMgmt")
    private Boolean sysPowermgmt;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("Sys.Syslog")
    private Boolean sysSyslog;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("User.Modify")
    private Boolean userModify;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Allocate")
    private Boolean vmAllocate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Audit")
    private Boolean vmAudit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Backup")
    private Boolean vmBackup;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Clone")
    private Boolean vmClone;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.CDROM")
    private Boolean vmConfigCdrom;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.CPU")
    private Boolean vmConfigCpu;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.Cloudinit")
    private Boolean vmConfigCloudinit;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.Disk")
    private Boolean vmConfigDisk;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.HWType")
    private Boolean vmConfigHwtype;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.Memory")
    private Boolean vmConfigMemory;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.Network")
    private Boolean vmConfigNetwork;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Config.Options")
    private Boolean vmConfigOptions;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Console")
    private Boolean vmConsole;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Migrate")
    private Boolean vmMigrate;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Monitor")
    private Boolean vmMonitor;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.PowerMgmt")
    private Boolean vmPowermgmt;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Snapshot")
    private Boolean vmSnapshot;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("VM.Snapshot.Rollback")
    private Boolean vmSnapshotRollback;


}
