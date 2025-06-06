package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 用于封装VM生命周期操作（如停止、删除）的选项
 */
public class VMLifecycleOptions {

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class StopOptions {
        private Integer timeout;
        @JsonProperty("migratedfrom")
        private String migratedFrom;
        @JsonProperty("skiplock")
        private Boolean skipLock;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ShutdownOptions {
        private Integer timeout;
        @JsonProperty("forceStop")
        private Boolean forceStop;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DeleteOptions {
        private Boolean force;
        @JsonProperty("skiplock")
        private Boolean skipLock;
        @JsonProperty("destroy-unreferenced-disks")
        private Boolean destroyUnreferencedDisks;
        private Boolean purge;
    }
}
