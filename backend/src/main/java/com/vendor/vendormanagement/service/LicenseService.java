package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.License;
import org.springframework.web.multipart.MultipartFile;

public interface LicenseService {
    public License findByID(int id);
    public String saveLicense(MultipartFile license, int restaurantId);
    public String updateLicense(MultipartFile license, int restaurantId);
    public String deleteLicense(int id);
    public String deleteLicenseByRestaurant(int restaurantId);
    public License findByRestaurant(int restaurantId);
}
