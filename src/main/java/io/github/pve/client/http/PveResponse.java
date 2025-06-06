package io.github.pve.client.http;


import lombok.Getter;
import okhttp3.Headers;

import java.util.Optional;

@Getter
public class PveResponse<T> {
    private final T data;
    private final Headers headers;
    private final int statusCode;

    public PveResponse(T data, Headers headers, int statusCode) {
        this.data = data;
        this.headers = headers;
        this.statusCode = statusCode;
    }

    public Optional<T> getData() {
        return Optional.ofNullable(data);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

}
