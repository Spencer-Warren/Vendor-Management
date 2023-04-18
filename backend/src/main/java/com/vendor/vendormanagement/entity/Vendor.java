package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vendorID;
    private String vendorName;
    private String vendorUsername;
    private String vendorPassword;
    private String vendorEmail;

    @OneToMany(mappedBy = "vendor", orphanRemoval = true)
    private List<Resturant> resturants;

    public Vendor() {
        vendorID = 0;
        vendorName = "";
        vendorUsername = "";
        vendorPassword = "";
        vendorEmail = "";
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorUsername() {
        return vendorUsername;
    }

    public void setVendorUsername(String vendorUsername) {
        this.vendorUsername = vendorUsername;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "VendorID=" + vendorID +
                ", VendorName='" + vendorName + '\'' +
                ", VendorUsername='" + vendorUsername + '\'' +
                ", VendorPassword='" + vendorPassword + '\'' +
                ", VendorEmail='" + vendorEmail + '\'' +
                '}';
    }
}
