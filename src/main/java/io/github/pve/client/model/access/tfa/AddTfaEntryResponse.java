package io.github.pve.client.model.access.tfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Add a TFA entry for a user.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTfaEntryResponse {

    /**
     * When adding u2f entries, this contains a challenge the user must respond to in order to finish the registration.
     * Type: string
     * Optional: True
     */
    @JsonProperty("challenge")
    private String challenge;

    /**
     * The id of a newly added TFA entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * When adding recovery codes, this contains the list of codes to be displayed to the user
     * Type: array
     * Optional: True
     */
    @JsonProperty("recovery")
    private List<String> recovery;


}
