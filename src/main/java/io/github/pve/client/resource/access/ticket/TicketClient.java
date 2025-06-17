package io.github.pve.client.resource.access.ticket;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.ticket.*;

/**
 * Client for /access/ticket
 * BY '@xiao-rao'
 */
public class TicketClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TicketClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/ticket";
    }

    /**
     * Dummy. Useful for formatters which want to provide a login page.
     */
    public void getTicket() {
        executor.get(this.basePath);
    }

    /**
     * Create or verify authentication ticket.
     */
    public CreateTicketResponse createTicket(CreateTicketRequest request) {
        PveResponse<CreateTicketResponse> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}