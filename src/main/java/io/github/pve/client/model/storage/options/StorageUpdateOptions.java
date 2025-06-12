package io.github.pve.client.model.storage.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import io.github.pve.client.model.Validatable;
import lombok.EqualsAndHashCode;

/**
 * 更新存储参数（PUT /storage/{storage}）
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageUpdateOptions extends StorageBaseOptions implements Validatable {
    /** 存储ID，必填 */
    @NotBlank(message = "存储ID不能为空")
    @JsonProperty("storage")
    private String storage;

    /** 删除指定内容（如某些配置项） */
    @JsonProperty("delete")
    private String delete;
} 