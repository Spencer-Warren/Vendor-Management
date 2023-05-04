package com.vendor.vendormanagement.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    private Response() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseEntity<String> response(String message, HttpStatus status) {
        message = "{\"response\": \"" + message + "\"}";
        return ResponseEntity.status(status).body(message);
    }
}
