package com.vendor.vendormanagement.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendorTest {

    @Test
    void setVendorID() {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1);
        assertEquals(1, vendor.getVendorID());
    }

    @Test
    void setVendorUsername() {
        Vendor vendor = new Vendor();
        vendor.setVendorUsername("username");
        assertEquals("username", vendor.getUsername());
    }

    @Test
    void setVendorPassword() {
        Vendor vendor = new Vendor();
        vendor.setVendorPassword("password");
        assertEquals("password", vendor.getPassword());
    }

    @Test
    void setVendorName() {
        Vendor vendor = new Vendor();
        vendor.setVendorName("name");
        assertEquals("name", vendor.getVendorName());
    }

    @Test
    void setVendorEmail() {
        Vendor vendor = new Vendor();
        vendor.setVendorEmail("email");
        assertEquals("email", vendor.getVendorEmail());
    }

    @Test
    void setVendorRole() {
        Vendor vendor = new Vendor();
        vendor.setVendorRole("role");
        assertEquals("role", vendor.getVendorRole());
    }

    @Test
    void testToString() {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1);
        vendor.setVendorName("name");
        vendor.setVendorUsername("username");
        vendor.setVendorPassword("password");
        vendor.setVendorEmail("email");
        assertEquals("Vendor{vendorID=1, vendorName='name', vendorUsername='username', vendorPassword='password', vendorEmail='email'}", vendor.toString());
    }

    @Test
    void getAuthorities() {
        Vendor vendor = new Vendor();
        assertEquals(List.of(), vendor.getAuthorities());
    }

    @Test
    void setPassword() {
        Vendor vendor = new Vendor();
        vendor.setPassword("password");
        assertEquals("password", vendor.getPassword());
    }

    @Test
    void isAccountNonExpired() {
        assertTrue(new Vendor().isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertTrue(new Vendor().isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertTrue(new Vendor().isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        assertTrue(new Vendor().isEnabled());
    }
}