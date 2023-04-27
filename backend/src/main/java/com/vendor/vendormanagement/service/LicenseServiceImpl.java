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
        dao.save(newLicense);
        return Response.response("Created License for Restaurant with ID: " + restaurantId, HttpStatus.CREATED);
    }

    @Override
    public License findByID(int id) {
        return dao.findById(id).orElseGet(License::new);
    }

    @Override
    public ResponseEntity<String> updateLicense(MultipartFile license, int restaurantId) {
        dao.save(new License(license, restaurantId));
        return Response.response("Updated License for Restaurant with ID: " + restaurantId, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteLicense(int id) {
        dao.deleteById(id);
        return Response.response("Deleted License with ID: " + id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteLicenseByRestaurant(int restaurantId) {
        dao.deleteByRestaurant(restaurantId);
        return Response.response("Deleted License for Restaurant with ID: " + restaurantId, HttpStatus.OK);
    }


    @Override
    public License findByRestaurant(int restaurantId) {
        return dao.findByRestaurant(restaurantId);
    }
}
