package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.auth.AuthenticationDetails;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.options.TicketCreationOptions;


import java.util.Map;

/**
 * 管理认证票据 (Tickets) - /access/ticket
 * 主要用于显式登录操作。
 */
public class TicketResourceClient {

    private final ProxmoxApiExecutor executor;

    public TicketResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }


    public AuthenticationDetails create(TicketCreationOptions options) throws Exception {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        PveResponse<AuthenticationDetails> r = executor.post("/access/ticket", null, params, new TypeReference<>() {
        });
        return r.getData().orElseThrow(() -> new Exception("Ticket creation failed"));
    }


}

