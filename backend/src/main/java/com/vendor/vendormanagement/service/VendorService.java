package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Vendor;

public interface VendorService {
    public Vendor saveVendor(Vendor vendor);
    public Vendor findByUsername(String username);
    public Vendor findByID(int id);
    public Vendor updateVendor(Vendor vendor);
    public String deleteVendor(int id);
    public boolean login(Vendor vendor);
}
