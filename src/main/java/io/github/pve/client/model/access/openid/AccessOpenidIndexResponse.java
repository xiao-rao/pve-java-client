package io.github.pve.client.model.access.openid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Directory index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessOpenidIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;


}
