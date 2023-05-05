package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.License;
import com.vendor.vendormanagement.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/license")
public class LicenseController {
    @Autowired
    private LicenseService service;

    @PostMapping("/{restaurantId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<String> newLicense(@RequestParam("file") MultipartFile license, @PathVariable int restaurantId) {
        return service.saveLicense(license, restaurantId);
    }

    @PutMapping("/{restaurantId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<String> updateLicense(@RequestParam("file") MultipartFile license, @PathVariable int restaurantId) {
        return service.updateLicense(license, restaurantId);
    }

    @GetMapping("/{restaurantId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<byte[]> getLicense(@PathVariable int restaurantId) {
        License license =  service.findByRestaurant(restaurantId);
        MediaType mediaType = MediaType.valueOf(license.getFileType());

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header("Content-Disposition", "filename=\"" + license.getFileName() + "\"")
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
                .body(license.getFileData());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<String> deleteLicense(@PathVariable int id) {
        return service.deleteLicense(id);
    }

}
