package io.github.pve.client.model.cluster.acme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Map;

/**
 * ACME插件信息
 */
@Data
public class AcmePlugin {
    /**
     * The plugin ID.
     */
    @JsonProperty("plugin")
    private String pluginId;

    /**
     * The plugin type.
     */
    private String type;

    /**
     * A list of nodes where this plugin is active.
     */
    private String nodes;

    /**
     * Plugin specific data.
     */
    private Map<String, String> data;

    /**
     * A list of domains this plugin should handle.
     */
    private String domains;

    /**
     * A comment for the plugin.
     */
    private String comment;

    /**
     * Whether the plugin is disabled.
     */
    @JsonProperty("disable")
    private Integer disabled;
}
