package io.github.pve.client.model.cluster.acme.options;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建或更新ACME账户时的参数选项
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcmeAccountCreationOrUpdateOptions {
    /**
     * The account name.
     */
    private String name; // Only for POST

    /**
     * The account's contact email addresses, comma-separated.
     */
    private String contact;

    /**
     * The account's directory URL.
     */
    private String directory;

    /**
     * Accept the ToS. Use the URL provided by the 'tos' command.
     */
    @JsonProperty("tos_url") // PVE API uses snake_case here
    private String termsOfServiceUrl;

    /**
     * Digest for update validation.
     */
    private String digest; // Only for PUT
}
