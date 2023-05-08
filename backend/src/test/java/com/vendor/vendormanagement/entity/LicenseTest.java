package com.vendor.vendormanagement.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseTest {

    @Test
    void setLicenseID() {
       License license = new License();
       license.setLicenseID(1);
       assertEquals(1, license.getLicenseID());
    }

    @Test
    void setFileData() {
        License license = new License();
        byte[] fileData = new byte[1];
        license.setFileData(fileData);
        assertEquals(fileData, license.getFileData());
    }

    @Test
    void setFileName() {
        License license = new License();
        license.setFileName("File Name");
        assertEquals("File Name", license.getFileName());
    }

    @Test
    void setFileType() {
        License license = new License();
        license.setFileType("File Type");
        assertEquals("File Type", license.getFileType());
    }

    @Test
    void setRestaurantID() {
        License license = new License();
        license.setRestaurantID(1);
        assertEquals(1, license.getRestaurantID());
    }

    @Test
    void testToString() {
        License license = new License();
        license.setLicenseID(1);
        license.setFileName("File Name");
        license.setFileType("File Type");
        license.setRestaurantID(1);
        assertEquals("License{licenseID=1, fileName='File Name', fileType='File Type', restaurantID=1}", license.toString());
    }
}