package io.github.pve.client.model.cluster.acme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * ACME账户信息
 */
@Data
public class AcmeAccount {
    /**
     * The account name.
     */
    private String name;

    /**
     * The account's status.
     */
    private String status;

    /**
     * The account's directory URL.
     */
    private String directory;

    /**
     * The account's ToS URL.
     */
    @JsonProperty("tos")
    private String termsOfService;

    /**
     * The account's contact email addresses.
     */
    private List<String> contact;

    /**
     * The account's location URL.
     */
    @JsonProperty("location")
    private String locationUrl;

    /**
     * The account's private key details.
     */
    @JsonProperty("key")
    private Map<String, String> keyDetails;
}

