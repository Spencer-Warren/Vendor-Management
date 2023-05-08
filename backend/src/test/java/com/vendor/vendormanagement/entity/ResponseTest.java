package com.vendor.vendormanagement.entity;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void of() {
        Response.of("test", HttpStatus.OK);
        assertEquals(Response.of("test", HttpStatus.OK).getStatusCodeValue(), 200);
        assertEquals(Response.of("test", HttpStatus.OK).getBody(), "{\"message\":\"test\"}");
    }

    @Test
    void testOf() {
        Response.of("test");
        assertEquals(Response.of("test").getStatusCodeValue(), 200);
        assertEquals(Response.of("test").getBody(), "{\"message\":\"test\"}");
    }

    @Test
    void testOf2() {
        Response.of(1);
        assertEquals(Response.of(1).getStatusCodeValue(), 200);
        assertEquals(Response.of(1).getBody(), 1);
    }

    @Test
    void throwTest() {
        assertThrows(IllegalStateException.class, () -> {
            Response response = new Response();
        });
    }
}