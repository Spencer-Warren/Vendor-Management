package com.vendor.vendormanagement.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    private Response() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> ResponseEntity<T> of(T body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }

    public static <T> ResponseEntity<T> of(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
