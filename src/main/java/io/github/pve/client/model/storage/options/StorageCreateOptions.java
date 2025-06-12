package io.github.pve.client.model.storage.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import io.github.pve.client.model.Validatable;
import lombok.EqualsAndHashCode;

/**
 * 创建存储参数（POST /storage）
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageCreateOptions extends StorageBaseOptions implements Validatable {
    /** 存储ID，必填 */
    @NotBlank(message = "存储ID不能为空")
    @JsonProperty("storage")
    private String storage;

    /** 存储类型，必填 */
    @NotBlank(message = "存储类型不能为空")
    @JsonProperty("type")
    private String type;

    /** 目录内容类型（dir类型专用） */
    @JsonProperty("content-dirs")
    private String contentDirs;
    /** 磁盘格式（如qcow2/raw） */
    @JsonProperty("format")
    private String format;
    /** 基础镜像 */
    @JsonProperty("base")
    private String base;
} 