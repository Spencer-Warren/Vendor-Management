package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.LicenseDao;
import com.vendor.vendormanagement.entity.License;
import com.vendor.vendormanagement.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LicenseServiceImpl implements LicenseService{
    @Autowired
    LicenseDao dao;

    @Override
    public ResponseEntity<String> saveLicense(MultipartFile license, int restaurantId) {
        License newLicense = new License(license, restaurantId);
        if (dao.findByRestaurant(restaurantId) != null) {
            return updateLicense(license, restaurantId);
        }
        dao.save(newLicense);
        return Response.of("Created License for Restaurant with ID: " + restaurantId, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateLicense(MultipartFile license, int restaurantId) {
        dao.deleteByRestaurant(restaurantId);
        dao.save(new License(license, restaurantId));
        return Response.of("Updated License for Restaurant with ID: " + restaurantId);
    }

    @Override
    public ResponseEntity<String> deleteLicense(int id) {
        dao.deleteById(id);
        return Response.of("Deleted License with ID: " + id);
    }

    @Override
    public ResponseEntity<String> deleteLicenseByRestaurant(int restaurantId) {
        dao.deleteByRestaurant(restaurantId);
        return Response.of("Deleted License for Restaurant with ID: " + restaurantId);
    }


    @Override
    public License findByRestaurant(int restaurantId) {
        return dao.findByRestaurant(restaurantId);
    }
}
