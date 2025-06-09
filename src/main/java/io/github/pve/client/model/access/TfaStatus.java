package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class TfaStatus {
    private List<TfaEntry> entries;
    private String ticket;
    @JsonProperty("totp_url")
    private String totpUrl;

    @Data
    public static class TfaEntry {
        private String id;
        private String description;
        private String type;
        private Long created;
    }
}
