package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.License;
import com.vendor.vendormanagement.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/license")
public class LicenseController {
    @Autowired
    private LicenseService service;

    @PostMapping("/{restaurantId}")
    public String newLicense(@RequestParam("file") MultipartFile license, @PathVariable int restaurantId) {
        return service.saveLicense(license, restaurantId);
    }

    @PutMapping("/{restaurantId}")
    public String updateLicense(@RequestParam("file") MultipartFile license, @PathVariable int restaurantId) {
        return service.updateLicense(license, restaurantId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getLicense(@PathVariable int id) {
        MediaType mediaType = MediaType.valueOf(service.findByID(id).getFileType());

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(service.findByID(id).getFileData());
    }

    @DeleteMapping("/{id}")
    public String deleteLicense(@PathVariable int id) {
        return service.deleteLicense(id);
    }

}