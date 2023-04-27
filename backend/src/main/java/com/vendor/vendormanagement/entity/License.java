package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int licenseID;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] fileData;
    private String fileName;
    private String fileType;
    private int restaurantID;

    public License(MultipartFile file, int restaurantID) {
        this.restaurantID = restaurantID;
        try {
            this.fileData = file.getBytes();
            this.fileName = file.getOriginalFilename();
            this.fileType = file.getContentType();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public License() {
        licenseID = 0;
        fileData = null;
        fileName = "";
        fileType = "";
        restaurantID = 0;
    }

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getRestaurantID() {
        return restaurantID;
    }
    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseID=" + licenseID +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", restaurantID=" + restaurantID +
                '}';
    }
}
