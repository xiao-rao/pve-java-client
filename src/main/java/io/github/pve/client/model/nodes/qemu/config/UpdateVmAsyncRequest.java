package io.github.pve.client.model.nodes.qemu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Set virtual machine options (asynchronous API).
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateVmAsyncRequest {

    /**
     * Enable/disable ACPI.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("acpi")
    private Boolean acpi;

    /**
     * List of host cores used to execute guest processes, for example: 0,5,8-11
     * Type: string
     * Optional: True
     */
    @JsonProperty("affinity")
    private String affinity;

    /**
     * Enable/disable communication with the QEMU Guest Agent and its properties.
     * Type: string
     * Optional: True
     */
    @JsonProperty("agent")
    private String agent;

    /**
     * Secure Encrypted Virtualization (SEV) features by AMD CPUs
     * Type: string
     * Optional: True
     */
    @JsonProperty("amd-sev")
    private String amdSev;

    /**
     * Virtual processor architecture. Defaults to the host.
     * Type: string
     * Optional: True
     */
    @JsonProperty("arch")
    private String arch;

    /**
     * Arbitrary arguments passed to kvm.
     * Type: string
     * Optional: True
     */
    @JsonProperty("args")
    private String args;

    /**
     * Configure a audio device, useful in combination with QXL/Spice.
     * Type: string
     * Optional: True
     */
    @JsonProperty("audio0")
    private String audio0;

    /**
     * Automatic restart after crash (currently ignored).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("autostart")
    private Boolean autostart;

    /**
     * Time to wait for the task to finish. We return 'null' if the task finish within that time.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("background_delay")
    private Integer backgroundDelay;

    /**
     * Amount of target RAM for the VM in MiB. Using zero disables the ballon driver.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("balloon")
    private Integer balloon;

    /**
     * Select BIOS implementation.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bios")
    private String bios;

    /**
     * Specify guest boot order. Use the 'order=' sub-property as usage with no key or 'legacy=' is deprecated.
     * Type: string
     * Optional: True
     */
    @JsonProperty("boot")
    private String boot;

    /**
     * Enable booting from specified disk. Deprecated: Use 'boot: order=foo;bar' instead.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="(ide|sata|scsi|virtio)\\d+", message="Parameter 'bootdisk' does not match pattern")
    @JsonProperty("bootdisk")
    private String bootdisk;

    /**
     * This is an alias for option -ide2
     * Type: string
     * Optional: True
     */
    @JsonProperty("cdrom")
    private String cdrom;

    /**
     * cloud-init: Specify custom files to replace the automatically generated ones at start.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cicustom")
    private String cicustom;

    /**
     * cloud-init: Password to assign the user. Using this is generally not recommended. Use ssh keys instead. Also note that older cloud-init versions do not support hashed passwords.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cipassword")
    private String cipassword;

    /**
     * Specifies the cloud-init configuration format. The default depends on the configured operating system type (`ostype`. We use the `nocloud` format for Linux, and `configdrive2` for windows.
     * Type: string
     * Optional: True
     */
    @JsonProperty("citype")
    private String citype;

    /**
     * cloud-init: do an automatic package upgrade after the first boot.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ciupgrade")
    private Boolean ciupgrade;

    /**
     * cloud-init: User name to change ssh keys and password for instead of the image's configured default user.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ciuser")
    private String ciuser;

    /**
     * The number of cores per socket.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("cores")
    private Integer cores;

    /**
     * Emulated CPU type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cpu")
    private String cpu;

    /**
     * Limit of CPU usage.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpulimit")
    private Double cpulimit;

    /**
     * CPU weight for a VM, will be clamped to [1, 10000] in cgroup v2.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("cpuunits")
    private Integer cpuunits;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

    /**
     * Description for the VM. Shown in the web-interface VM's summary. This is saved as comment inside the configuration file.
     * Type: string
     * Optional: True
     */
    @Size(max=8192, message="Parameter 'description' length must not exceed 8192")
    @JsonProperty("description")
    private String description;

    /**
     * Prevent changes if current configuration file has different SHA1 digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'digest' length must not exceed 40")
    @JsonProperty("digest")
    private String digest;

    /**
     * Configure a disk for storing EFI vars. Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Note that SIZE_IN_GiB is ignored here and that the default EFI vars are copied to the volume instead. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume.
     * Type: string
     * Optional: True
     */
    @JsonProperty("efidisk0")
    private String efidisk0;

    /**
     * Force physical removal. Without this, we simple remove the disk from the config file and create an additional configuration entry called 'unused[n]', which contains the volume ID. Unlink of unused[n] always cause physical removal.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force")
    private Boolean force;

    /**
     * Freeze CPU at startup (use 'c' monitor command to start execution).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("freeze")
    private Boolean freeze;

    /**
     * Script that will be executed during various steps in the vms lifetime.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hookscript")
    private String hookscript;

    /**
     * Map host PCI devices into guest. (Array parameter: use Map with integer keys for hostpci0, hostpci1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("hostpci")
    private Map<Integer, String> hostpci;

    /**
     * Selectively enable hotplug features. This is a comma separated list of hotplug features: 'network', 'disk', 'cpu', 'memory', 'usb' and 'cloudinit'. Use '0' to disable hotplug completely. Using '1' as value is an alias for the default `network,disk,usb`. USB hotplugging is possible for guests with machine version >= 7.1 and ostype l26 or windows > 7.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hotplug")
    private String hotplug;

    /**
     * Enable/disable hugepages memory.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hugepages")
    private String hugepages;

    /**
     * Use volume as IDE hard disk or CD-ROM (n is 0 to 3). Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume. (Array parameter: use Map with integer keys for ide0, ide1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("ide")
    private Map<Integer, String> ide;

    /**
     * A file-based storage with 'images' content-type enabled, which is used as an intermediary extraction storage during import. Defaults to the source storage.
     * Type: string
     * Optional: True
     */
    @JsonProperty("import-working-storage")
    private String importWorkingStorage;

    /**
     * cloud-init: Specify IP addresses and gateways for the corresponding interface.  IP addresses use CIDR notation, gateways are optional but need an IP of the same type specified.  The special string 'dhcp' can be used for IP addresses to use DHCP, in which case no explicit gateway should be provided. For IPv6 the special string 'auto' can be used to use stateless autoconfiguration. This requires cloud-init 19.4 or newer.  If cloud-init is enabled and neither an IPv4 nor an IPv6 address is specified, it defaults to using dhcp on IPv4.  (Array parameter: use Map with integer keys for ipconfig0, ipconfig1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("ipconfig")
    private Map<Integer, String> ipconfig;

    /**
     * Inter-VM shared memory. Useful for direct communication between VMs, or to the host.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ivshmem")
    private String ivshmem;

    /**
     * Use together with hugepages. If enabled, hugepages will not not be deleted after VM shutdown and can be used for subsequent starts.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("keephugepages")
    private Boolean keephugepages;

    /**
     * Keyboard layout for VNC server. This option is generally not required and is often better handled from within the guest OS.
     * Type: string
     * Optional: True
     */
    @JsonProperty("keyboard")
    private String keyboard;

    /**
     * Enable/disable KVM hardware virtualization.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("kvm")
    private Boolean kvm;

    /**
     * Set the real time clock (RTC) to local time. This is enabled by default if the `ostype` indicates a Microsoft Windows OS.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("localtime")
    private Boolean localtime;

    /**
     * Lock/unlock the VM.
     * Type: string
     * Optional: True
     */
    @JsonProperty("lock")
    private String lock;

    /**
     * Specify the QEMU machine.
     * Type: string
     * Optional: True
     */
    @JsonProperty("machine")
    private String machine;

    /**
     * Memory properties.
     * Type: string
     * Optional: True
     */
    @JsonProperty("memory")
    private String memory;

    /**
     * Set maximum tolerated downtime (in seconds) for migrations. Should the migration not be able to converge in the very end, because too much newly dirtied RAM needs to be transferred, the limit will be increased automatically step-by-step until migration can converge.
     * Type: number
     * Optional: True
     */
    @JsonProperty("migrate_downtime")
    private Double migrateDowntime;

    /**
     * Set maximum speed (in MB/s) for migrations. Value 0 is no limit.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("migrate_speed")
    private Integer migrateSpeed;

    /**
     * Set a name for the VM. Only used on the configuration web interface.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * cloud-init: Sets DNS server IP address for a container. Create will automatically use the setting from the host if neither searchdomain nor nameserver are set.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nameserver")
    private String nameserver;

    /**
     * Specify network devices. (Array parameter: use Map with integer keys for net0, net1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("net")
    private Map<Integer, String> net;

    /**
     * Enable/disable NUMA.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("numa")
    private Boolean numa;

    /**
     * NUMA topology. (Array parameter: use Map with integer keys for numa0, numa1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("numa")
    private Map<Integer, String> numaArray;

    /**
     * Specifies whether a VM will be started during system bootup.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("onboot")
    private Boolean onboot;

    /**
     * Specify guest operating system.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ostype")
    private String ostype;

    /**
     * Map host parallel devices (n is 0 to 2). (Array parameter: use Map with integer keys for parallel0, parallel1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("parallel")
    private Map<Integer, String> parallel;

    /**
     * Sets the protection flag of the VM. This will disable the remove VM and remove disk operations.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protection")
    private Boolean protection;

    /**
     * Allow reboot. If set to '0' the VM exit on reboot.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("reboot")
    private Boolean reboot;

    /**
     * Revert a pending change.
     * Type: string
     * Optional: True
     */
    @JsonProperty("revert")
    private String revert;

    /**
     * Configure a VirtIO-based Random Number Generator.
     * Type: string
     * Optional: True
     */
    @JsonProperty("rng0")
    private String rng0;

    /**
     * Use volume as SATA hard disk or CD-ROM (n is 0 to 5). Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume. (Array parameter: use Map with integer keys for sata0, sata1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("sata")
    private Map<Integer, String> sata;

    /**
     * Use volume as SCSI hard disk or CD-ROM (n is 0 to 30). Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume. (Array parameter: use Map with integer keys for scsi0, scsi1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("scsi")
    private Map<Integer, String> scsi;

    /**
     * SCSI controller model
     * Type: string
     * Optional: True
     */
    @JsonProperty("scsihw")
    private String scsihw;

    /**
     * cloud-init: Sets DNS search domains for a container. Create will automatically use the setting from the host if neither searchdomain nor nameserver are set.
     * Type: string
     * Optional: True
     */
    @JsonProperty("searchdomain")
    private String searchdomain;

    /**
     * Create a serial device inside the VM (n is 0 to 3) (Array parameter: use Map with integer keys for serial0, serial1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("serial")
    private Map<Integer, String> serial;

    /**
     * Amount of memory shares for auto-ballooning. The larger the number is, the more memory this VM gets. Number is relative to weights of all other running VMs. Using zero disables auto-ballooning. Auto-ballooning is done by pvestatd.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("shares")
    private Integer shares;

    /**
     * Ignore locks - only root is allowed to use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skiplock")
    private Boolean skiplock;

    /**
     * Specify SMBIOS type 1 fields.
     * Type: string
     * Optional: True
     */
    @Size(max=512, message="Parameter 'smbios1' length must not exceed 512")
    @JsonProperty("smbios1")
    private String smbios1;

    /**
     * The number of CPUs. Please use option -sockets instead.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("smp")
    private Integer smp;

    /**
     * The number of CPU sockets.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("sockets")
    private Integer sockets;

    /**
     * Configure additional enhancements for SPICE.
     * Type: string
     * Optional: True
     */
    @JsonProperty("spice_enhancements")
    private String spiceEnhancements;

    /**
     * cloud-init: Setup public SSH keys (one key per line, OpenSSH format).
     * Type: string
     * Optional: True
     */
    @JsonProperty("sshkeys")
    private String sshkeys;

    /**
     * Set the initial date of the real time clock. Valid format for date are:'now' or '2006-06-17T16:01:21' or '2006-06-17'.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="(now|\\d{4}-\\d{1,2}-\\d{1,2}(T\\d{1,2}:\\d{1,2}:\\d{1,2})?)", message="Parameter 'startdate' does not match pattern")
    @JsonProperty("startdate")
    private String startdate;

    /**
     * Startup and shutdown behavior. Order is a non-negative number defining the general startup order. Shutdown in done with reverse ordering. Additionally you can set the 'up' or 'down' delay in seconds, which specifies a delay to wait before the next VM is started or stopped.
     * Type: string
     * Optional: True
     */
    @JsonProperty("startup")
    private String startup;

    /**
     * Enable/disable the USB tablet device.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("tablet")
    private Boolean tablet;

    /**
     * Tags of the VM. This is only meta information.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * Enable/disable time drift fix.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("tdf")
    private Boolean tdf;

    /**
     * Enable/disable Template.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("template")
    private Boolean template;

    /**
     * Configure a Disk for storing TPM state. The format is fixed to 'raw'. Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Note that SIZE_IN_GiB is ignored here and 4 MiB will be used instead. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tpmstate0")
    private String tpmstate0;

    /**
     * Reference to unused volumes. This is used internally, and should not be modified manually. (Array parameter: use Map with integer keys for unused0, unused1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("unused")
    private Map<Integer, String> unused;

    /**
     * Configure an USB device (n is 0 to 4, for machine version >= 7.1 and ostype l26 or windows > 7, n can be up to 14). (Array parameter: use Map with integer keys for usb0, usb1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("usb")
    private Map<Integer, String> usb;

    /**
     * Number of hotplugged vcpus.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vcpus")
    private Integer vcpus;

    /**
     * Configure the VGA hardware.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vga")
    private String vga;

    /**
     * Use volume as VIRTIO hard disk (n is 0 to 15). Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. Use STORAGE_ID:0 and the 'import-from' parameter to import from an existing volume. (Array parameter: use Map with integer keys for virtio0, virtio1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("virtio")
    private Map<Integer, String> virtio;

    /**
     * Configuration for sharing a directory between host and guest using Virtio-fs. (Array parameter: use Map with integer keys for virtiofs0, virtiofs1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("virtiofs")
    private Map<Integer, String> virtiofs;

    /**
     * Default storage for VM state volumes/files.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vmstatestorage")
    private String vmstatestorage;

    /**
     * Create a virtual hardware watchdog device.
     * Type: string
     * Optional: True
     */
    @JsonProperty("watchdog")
    private String watchdog;

    /**
     * Path parameter: vmgenid
     * Type: string
     * Optional: True
     */
    @JsonProperty("vmgenid")
    private String vmgenId;


    
    // Custom JSON handling for array parameters
    @JsonAnySetter
    public void setArrayParameter(String key, Object value) {
        if (key.startsWith("hostpci")) {
            if (this.hostpci == null) {
                this.hostpci = new HashMap<>();
            }
            try {
                String indexStr = key.substring(7);
                Integer index = Integer.parseInt(indexStr);
                this.hostpci.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("ide")) {
            if (this.ide == null) {
                this.ide = new HashMap<>();
            }
            try {
                String indexStr = key.substring(3);
                Integer index = Integer.parseInt(indexStr);
                this.ide.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("ipconfig")) {
            if (this.ipconfig == null) {
                this.ipconfig = new HashMap<>();
            }
            try {
                String indexStr = key.substring(8);
                Integer index = Integer.parseInt(indexStr);
                this.ipconfig.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("net")) {
            if (this.net == null) {
                this.net = new HashMap<>();
            }
            try {
                String indexStr = key.substring(3);
                Integer index = Integer.parseInt(indexStr);
                this.net.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("numa")) {
            if (this.numaArray == null) {
                this.numaArray = new HashMap<>();
            }
            try {
                String indexStr = key.substring(4);
                Integer index = Integer.parseInt(indexStr);
                this.numaArray.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("parallel")) {
            if (this.parallel == null) {
                this.parallel = new HashMap<>();
            }
            try {
                String indexStr = key.substring(8);
                Integer index = Integer.parseInt(indexStr);
                this.parallel.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("sata")) {
            if (this.sata == null) {
                this.sata = new HashMap<>();
            }
            try {
                String indexStr = key.substring(4);
                Integer index = Integer.parseInt(indexStr);
                this.sata.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("scsi")) {
            if (this.scsi == null) {
                this.scsi = new HashMap<>();
            }
            try {
                String indexStr = key.substring(4);
                Integer index = Integer.parseInt(indexStr);
                this.scsi.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("serial")) {
            if (this.serial == null) {
                this.serial = new HashMap<>();
            }
            try {
                String indexStr = key.substring(6);
                Integer index = Integer.parseInt(indexStr);
                this.serial.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("unused")) {
            if (this.unused == null) {
                this.unused = new HashMap<>();
            }
            try {
                String indexStr = key.substring(6);
                Integer index = Integer.parseInt(indexStr);
                this.unused.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("usb")) {
            if (this.usb == null) {
                this.usb = new HashMap<>();
            }
            try {
                String indexStr = key.substring(3);
                Integer index = Integer.parseInt(indexStr);
                this.usb.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("virtio")) {
            if (this.virtio == null) {
                this.virtio = new HashMap<>();
            }
            try {
                String indexStr = key.substring(6);
                Integer index = Integer.parseInt(indexStr);
                this.virtio.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("virtiofs")) {
            if (this.virtiofs == null) {
                this.virtiofs = new HashMap<>();
            }
            try {
                String indexStr = key.substring(8);
                Integer index = Integer.parseInt(indexStr);
                this.virtiofs.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
    }
    
    @JsonAnyGetter
    public Map<String, Object> getArrayParameters() {
        Map<String, Object> result = new HashMap<>();
        if (this.hostpci != null) {
            this.hostpci.forEach((index, value) -> 
                result.put("hostpci" + index, value));
        }
        if (this.ide != null) {
            this.ide.forEach((index, value) -> 
                result.put("ide" + index, value));
        }
        if (this.ipconfig != null) {
            this.ipconfig.forEach((index, value) -> 
                result.put("ipconfig" + index, value));
        }
        if (this.net != null) {
            this.net.forEach((index, value) -> 
                result.put("net" + index, value));
        }
        if (this.numaArray != null) {
            this.numaArray.forEach((index, value) -> 
                result.put("numa" + index, value));
        }
        if (this.parallel != null) {
            this.parallel.forEach((index, value) -> 
                result.put("parallel" + index, value));
        }
        if (this.sata != null) {
            this.sata.forEach((index, value) -> 
                result.put("sata" + index, value));
        }
        if (this.scsi != null) {
            this.scsi.forEach((index, value) -> 
                result.put("scsi" + index, value));
        }
        if (this.serial != null) {
            this.serial.forEach((index, value) -> 
                result.put("serial" + index, value));
        }
        if (this.unused != null) {
            this.unused.forEach((index, value) -> 
                result.put("unused" + index, value));
        }
        if (this.usb != null) {
            this.usb.forEach((index, value) -> 
                result.put("usb" + index, value));
        }
        if (this.virtio != null) {
            this.virtio.forEach((index, value) -> 
                result.put("virtio" + index, value));
        }
        if (this.virtiofs != null) {
            this.virtiofs.forEach((index, value) -> 
                result.put("virtiofs" + index, value));
        }
        return result;
    }
}
