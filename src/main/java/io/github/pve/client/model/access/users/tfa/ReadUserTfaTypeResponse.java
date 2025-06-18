package io.github.pve.client.model.access.users.tfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get user TFA types (Personal and Realm).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadUserTfaTypeResponse {

    /**
     * The type of TFA the users realm has set, if any.
     * Type: string
     * Optional: True
     */
    @JsonProperty("realm")
    private String realm;

    /**
     * Array of the user configured TFA types, if any. Only available if 'multiple' was not passed.
     * Type: array
     * Optional: True
     */
    @JsonProperty("types")
    private List<String> types;

    /**
     * The type of TFA the user has set, if any. Only set if 'multiple' was not passed.
     * Type: string
     * Optional: True
     */
    @JsonProperty("user")
    private String user;


}
