package com.app.users.shared.adapters.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message); // Esto permite usar ex.getMessage()
    }
}
