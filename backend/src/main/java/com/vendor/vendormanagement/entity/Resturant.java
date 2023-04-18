package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resturantID;
    private String resturantName;
    private String resturantLocation;
    private String resturantType;
    private String resturantCategory;

    @ManyToOne
    @JoinColumn(name="vendorID")
    private Vendor vendor;
    @OneToMany(mappedBy = "resturant")
    private List<Dish> dishes;

    public Resturant() {
        resturantID = 0;
        vendor = new Vendor();
        resturantName = "";
        resturantLocation = "";
        resturantType = "";
        resturantCategory = "";
    }

    public int getResturantID() {
        return resturantID;
    }

    public void setResturantID(int resturantID) {
        this.resturantID = resturantID;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public String getResturantLocation() {
        return resturantLocation;
    }

    public void setResturantLocation(String resturantLocation) {
        this.resturantLocation = resturantLocation;
    }

    public String getResturantType() {
        return resturantType;
    }

    public void setResturantType(String resturantType) {
        this.resturantType = resturantType;
    }

    public String getResturantCategory() {
        return resturantCategory;
    }

    public void setResturantCategory(String resturantCategory) {
        this.resturantCategory = resturantCategory;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "resturantID=" + resturantID +
                ", vendor=" + vendor +
                ", resturantName='" + resturantName + '\'' +
                ", resturantLocation='" + resturantLocation + '\'' +
                ", resturantType='" + resturantType + '\'' +
                ", resturantCategory='" + resturantCategory + '\'' +
                '}';
    }
}
