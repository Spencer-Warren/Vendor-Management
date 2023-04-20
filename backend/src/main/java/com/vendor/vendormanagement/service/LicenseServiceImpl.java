package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.LicenseDao;
import com.vendor.vendormanagement.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LicenseServiceImpl implements LicenseService{
    @Autowired
    LicenseDao dao;

    @Override
    public String saveLicense(MultipartFile license, int restaurantId) {
        License newLicense = new License(license, restaurantId);
        dao.save(newLicense);
        return "Saved License for Restaurant with ID: " + restaurantId;
    }

    @Override
    public License findByID(int id) {
        return dao.findById(id).orElseGet(License::new);
    }

    @Override
    public String updateLicense(MultipartFile license, int restaurantId) {
        dao.save(new License(license, restaurantId));
        return "Updated License for Restaurant with ID: " + restaurantId;
    }

    @Override
    public String deleteLicense(int id) {
        dao.deleteById(id);
        return "Deleted License with ID: " + id;
    }

    @Override
    public String deleteLicenseByRestaurant(int restaurantId) {
        dao.deleteByRestaurant(restaurantId);
        return "Deleted License for Restaurant with ID: " + restaurantId;
    }


    @Override
    public License findByRestaurant(int restaurantId) {
        return dao.findByRestaurant(restaurantId);
    }
}
