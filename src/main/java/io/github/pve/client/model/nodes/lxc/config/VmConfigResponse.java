package io.github.pve.client.model.nodes.lxc.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Get container configuration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmConfigResponse {

    /**
     * OS architecture type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("arch")
    private String arch;

    /**
     * Console mode. By default, the console command tries to open a connection to one of the available tty devices. By setting cmode to 'console' it tries to attach to /dev/console instead. If you set cmode to 'shell', it simply invokes a shell inside the container (no login).
     * Type: string
     * Optional: True
     */
    @JsonProperty("cmode")
    private String cmode;

    /**
     * Attach a console device (/dev/console) to the container.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("console")
    private Boolean console;

    /**
     * The number of cores assigned to the container. A container can use all available cores by default.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("cores")
    private Integer cores;

    /**
     * Limit of CPU usage.  NOTE: If the computer has 2 CPUs, it has a total of '2' CPU time. Value '0' indicates no CPU limit.
     * Type: number
     * Optional: True
     */
    @JsonProperty("cpulimit")
    private Double cpulimit;

    /**
     * CPU weight for a container, will be clamped to [1, 10000] in cgroup v2.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("cpuunits")
    private Integer cpuunits;

    /**
     * Try to be more verbose. For now this only enables debug log-level on start.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("debug")
    private Boolean debug;

    /**
     * Description for the Container. Shown in the web-interface CT's summary. This is saved as comment inside the configuration file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Device to pass through to the container (Array parameter: use Map with integer keys for dev0, dev1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("dev")
    private Map<Integer, String> dev;

    /**
     * SHA1 digest of configuration file. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * Allow containers access to advanced features.
     * Type: string
     * Optional: True
     */
    @JsonProperty("features")
    private String features;

    /**
     * Script that will be executed during various steps in the containers lifetime.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hookscript")
    private String hookscript;

    /**
     * Set a host name for the container.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hostname")
    private String hostname;

    /**
     * Lock/unlock the container.
     * Type: string
     * Optional: True
     */
    @JsonProperty("lock")
    private String lock;

    /**
     * Array of lxc low-level configurations ([[key1, value1], [key2, value2] ...]).
     * Type: array
     * Optional: True
     */
    @JsonProperty("lxc")
    private List<List<String>> lxc;

    /**
     * Amount of RAM for the container in MB.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("memory")
    private Integer memory;

    /**
     * Use volume as container mount point. Use the special syntax STORAGE_ID:SIZE_IN_GiB to allocate a new volume. (Array parameter: use Map with integer keys for mp0, mp1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("mp")
    private Map<Integer, String> mp;

    /**
     * Sets DNS server IP address for a container. Create will automatically use the setting from the host if you neither set searchdomain nor nameserver.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nameserver")
    private String nameserver;

    /**
     * Specifies network interfaces for the container. (Array parameter: use Map with integer keys for net0, net1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("net")
    private Map<Integer, String> net;

    /**
     * Specifies whether a container will be started during system bootup.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("onboot")
    private Boolean onboot;

    /**
     * OS type. This is used to setup configuration inside the container, and corresponds to lxc setup scripts in /usr/share/lxc/config/<ostype>.common.conf. Value 'unmanaged' can be used to skip and OS specific setup.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ostype")
    private String ostype;

    /**
     * Sets the protection flag of the container. This will prevent the CT or CT's disk remove/update operation.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protection")
    private Boolean protection;

    /**
     * Use volume as container root.
     * Type: string
     * Optional: True
     */
    @JsonProperty("rootfs")
    private String rootfs;

    /**
     * Sets DNS search domains for a container. Create will automatically use the setting from the host if you neither set searchdomain nor nameserver.
     * Type: string
     * Optional: True
     */
    @JsonProperty("searchdomain")
    private String searchdomain;

    /**
     * Startup and shutdown behavior. Order is a non-negative number defining the general startup order. Shutdown in done with reverse ordering. Additionally you can set the 'up' or 'down' delay in seconds, which specifies a delay to wait before the next VM is started or stopped.
     * Type: string
     * Optional: True
     */
    @JsonProperty("startup")
    private String startup;

    /**
     * Amount of SWAP for the container in MB.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("swap")
    private Integer swap;

    /**
     * Tags of the Container. This is only meta information.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tags")
    private String tags;

    /**
     * Enable/disable Template.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("template")
    private Boolean template;

    /**
     * Time zone to use in the container. If option isn't set, then nothing will be done. Can be set to 'host' to match the host time zone, or an arbitrary time zone option from /usr/share/zoneinfo/zone.tab
     * Type: string
     * Optional: True
     */
    @JsonProperty("timezone")
    private String timezone;

    /**
     * Specify the number of tty available to the container
     * Type: integer
     * Optional: True
     */
    @JsonProperty("tty")
    private Integer tty;

    /**
     * Makes the container run as unprivileged user. (Should not be modified manually.)
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("unprivileged")
    private Boolean unprivileged;

    /**
     * Reference to unused volumes. This is used internally, and should not be modified manually. (Array parameter: use Map with integer keys for unused0, unused1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("unused")
    private Map<Integer, String> unused;


    
    // Custom JSON handling for array parameters
    @JsonAnySetter
    public void setArrayParameter(String key, Object value) {
        if (key.startsWith("dev")) {
            if (this.dev == null) {
                this.dev = new HashMap<>();
            }
            try {
                String indexStr = key.substring(3);
                Integer index = Integer.parseInt(indexStr);
                this.dev.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
        if (key.startsWith("mp")) {
            if (this.mp == null) {
                this.mp = new HashMap<>();
            }
            try {
                String indexStr = key.substring(2);
                Integer index = Integer.parseInt(indexStr);
                this.mp.put(index, String.valueOf(value));
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
    }
    
    @JsonAnyGetter
    public Map<String, Object> getArrayParameters() {
        Map<String, Object> result = new HashMap<>();
        if (this.dev != null) {
            this.dev.forEach((index, value) -> 
                result.put("dev" + index, value));
        }
        if (this.mp != null) {
            this.mp.forEach((index, value) -> 
                result.put("mp" + index, value));
        }
        if (this.net != null) {
            this.net.forEach((index, value) -> 
                result.put("net" + index, value));
        }
        if (this.unused != null) {
            this.unused.forEach((index, value) -> 
                result.put("unused" + index, value));
        }
        return result;
    }
}
