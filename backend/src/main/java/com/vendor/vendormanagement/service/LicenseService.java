package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.License;

public interface LicenseService {
    public License saveLicense(License license);
    public License findByID(int id);
    public License updateLicense(License license);
    public String deleteLicense(int id);
    public License findByRestaurant(int restaurantId);
}
