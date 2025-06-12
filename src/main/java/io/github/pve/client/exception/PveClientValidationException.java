package io.github.pve.client.exception;

public class PveClientValidationException extends IllegalArgumentException {

    public PveClientValidationException(String message) {
        super(message);
    }

    public PveClientValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
