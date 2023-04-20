package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantID;
    private String restaurantName;
    private String restaurantLocation;
    private String restaurantType;
    private String restaurantCategory;

    @ManyToOne
    @JoinColumn(name="vendorID")
    private Vendor vendor;
    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

    public Restaurant() {
        restaurantID = 0;
        vendor = new Vendor();
        restaurantName = "";
        restaurantLocation = "";
        restaurantType = "";
        restaurantCategory = "";
    }

    public int getResturantID() {
        return restaurantID;
    }

    public void setResturantID(int resturantID) {
        this.restaurantID = resturantID;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "resturantID=" + restaurantID +
                ", vendor=" + vendor +
                ", resturantName='" + restaurantName + '\'' +
                ", resturantLocation='" + restaurantLocation + '\'' +
                ", resturantType='" + restaurantType + '\'' +
                ", resturantCategory='" + restaurantCategory + '\'' +
                '}';
    }
}
