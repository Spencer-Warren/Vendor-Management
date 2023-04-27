package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.License;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface LicenseService {
    public License findByID(int id);
    public ResponseEntity<String> saveLicense(MultipartFile license, int restaurantId);
    public ResponseEntity<String> updateLicense(MultipartFile license, int restaurantId);
    public ResponseEntity<String> deleteLicense(int id);
    public ResponseEntity<String> deleteLicenseByRestaurant(int restaurantId);
    public License findByRestaurant(int restaurantId);
}
