package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.http.ResponseEntity;

public interface VendorService {
    public Vendor saveVendor(Vendor vendor);
    public Vendor findByUsername(String username);
    public Vendor findByID(int id);
    public ResponseEntity<String> updateVendor(Vendor vendor);
    public ResponseEntity<String> deleteVendor(int id);
    public Vendor login(Vendor vendor);
}
