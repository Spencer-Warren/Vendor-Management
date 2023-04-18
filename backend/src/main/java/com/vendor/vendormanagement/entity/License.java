package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int licenseID;

    @Lob
    private byte[] fileData;


}
