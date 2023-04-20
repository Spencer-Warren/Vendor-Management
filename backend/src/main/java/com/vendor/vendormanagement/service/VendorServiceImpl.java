package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.VendorDao;
import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    VendorDao dao;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return dao.save(vendor);
    }

    @Override
    public Vendor findByUsername(String username) {
        return dao.findByVendorusername(username);
    }

    @Override
    public Vendor findByID(int id) {
        return dao.findById(id).orElseGet(Vendor::new);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        if (dao.findById(vendor.getVendorID()).isPresent()) {
            return dao.save(vendor);
        }
        return null;
    }

    @Override
    public String deleteVendor(int id) {
        dao.deleteById(id);
        return "Deleted Vendor with ID:" + id;
    }

    @Override
    public boolean login(Vendor vendor) {
        Vendor v = dao.findByVendorusernameAndPassword(vendor.getVendorUsername(), vendor.getVendorPassword());
        return v != null;
    }
}