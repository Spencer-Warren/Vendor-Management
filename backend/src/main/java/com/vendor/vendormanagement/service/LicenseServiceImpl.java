package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.LicenseDao;
import com.vendor.vendormanagement.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceImpl implements LicenseService{
    @Autowired
    LicenseDao dao;

    @Override
    public License saveLicense(License license) {
        return dao.save(license);
    }

    @Override
    public License findByID(int id) {
        return dao.findById(id).orElseGet(License::new);
    }

    @Override
    public License updateLicense(License license) {
        return dao.save(license);
    }

    @Override
    public String deleteLicense(int id) {
        dao.deleteById(id);
        return "Deleted License with ID: " + id;
    }

    @Override
    public License findByRestaurant(int restaurantId) {
        return dao.findByRestaurant(restaurantId);
    }
}
