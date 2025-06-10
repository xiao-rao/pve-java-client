package io.github.pve.client.model.cluster.acme.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


/**
 * 创建或更新ACME插件时的参数选项
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcmePluginCreationOrUpdateOptions {
    /**
     * The plugin ID.
     */
    @JsonProperty("plugin")
    private String pluginId; // For POST only

    /**
     * The plugin type.
     */
    private String type;

    /**
     * Plugin specific data, as a single string (e.g., "username=user,password=pass").
     */
    private String data;

    /**
     * A list of nodes where this plugin should be active, comma-separated.
     */
    private String nodes;

    /**
     * A list of domains this plugin should handle, comma-separated.
     */
    private String domains;

    /**
     * A comment for the plugin.
     */
    private String comment;

    /**
     * Whether to disable the plugin.
     */
    @JsonProperty("disable")
    private Boolean disabled;

    /**
     * Digest for update validation.
     */
    private String digest; // For PUT only
}
