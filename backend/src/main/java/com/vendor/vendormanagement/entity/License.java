package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int licenseID;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] fileData;
    private String fileName;
    private String fileType;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "restaurantID")
    private Restaurant restaurant;

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

    public Restaurant getResturant() {
        return restaurant;
    }

    public void setResturant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseID=" + licenseID +
                ", fileData=" + Arrays.toString(fileData) +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", resturant=" + restaurant +
                '}';
    }
}
