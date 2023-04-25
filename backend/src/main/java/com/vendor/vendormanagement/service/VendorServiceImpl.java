package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.VendorDao;
import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    VendorDao dao;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        vendor.setPassword(encoder.encode(vendor.getPassword()));
        vendor.setVendorRole("ROLE_VENDOR");
        return dao.save(vendor);
    }

    @Override
    public Vendor findByUsername(String username) {
        System.out.println("Username: " + username);
        Vendor vendor = dao.findByVendorusername(username);
        System.out.println("Vendor: " + vendor);
        return vendor;
    }

    @Override
    public Vendor findByID(int id) {
        return dao.findById(id).orElseGet(Vendor::new);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        if (dao.findById(vendor.getVendorID()).isPresent()) {
            vendor.setVendorRole("ROLE_VENDOR");
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
    public Vendor login(Vendor vendor) {
        String password = vendor.getPassword();
        Vendor v = dao.findByVendorusername(vendor.getUsername());
        if (v != null) {
            if (encoder.matches(password, v.getPassword())) {
                return v;
            }
        }
        return new Vendor();
    }
}
