package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Vendor;
import com.vendor.vendormanagement.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VendorController {
    @Autowired
    VendorService service;

    @PostMapping("/register")
    public Vendor newVendor(@RequestBody Vendor vendor) {
        return service.saveVendor(vendor);
    }

    @PutMapping("/vendor")
    public Vendor updateVendor(@RequestBody Vendor vendor) {
        return service.updateVendor(vendor);
    }

    @GetMapping("/vendor/id/{vendorId}")
    public Vendor getVendorById(@PathVariable int id){
        return service.findByID(id);
    }

    @GetMapping("/vendor/{username}")
    public Vendor getVendorByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @DeleteMapping("/vendor/{vendorId}")
    public String deleteVendor(@PathVariable int vendorId) {
        return service.deleteVendor(vendorId);
    }

    @PostMapping("/login")
    public Vendor login(@RequestBody Vendor vendor) {
        return service.login(vendor);
    }

}
