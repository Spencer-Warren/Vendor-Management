package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.VendorDao;
import com.vendor.vendormanagement.entity.Response;
import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    VendorDao dao;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public ResponseEntity<Vendor> saveVendor(Vendor vendor) {
        vendor.setPassword(encoder.encode(vendor.getPassword()));
        vendor.setVendorRole("ROLE_VENDOR");
        return Response.of(dao.save(vendor));
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
    public ResponseEntity<String> updateVendor(Vendor vendor) {
        System.out.println(vendor);
        dao.updateVendor(vendor.getVendorName(), vendor.getUsername(), vendor.getVendorEmail(), vendor.getVendorID());
        return ResponseEntity.ok("Updated Vendor with ID:" + vendor.getVendorID());
    }

    @Override
    public ResponseEntity<String> deleteVendor(int id) {
        dao.deleteById(id);
        return ResponseEntity.ok("Deleted Vendor with ID:" + id);
    }

    @Override
    public Vendor login(Vendor vendor) {
        String password = vendor.getPassword();
        Vendor v = dao.findByVendorusername(vendor.getUsername());
        if (v != null && encoder.matches(password, v.getPassword())) {
            return v;
        }
        return new Vendor();
    }
}
