package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dishID;
    private String dishName;
    private double dishPrice;
    @Column(length = 1024)
    private String dishDescription;
    private String dishCategory;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="restaurantID")
    private Restaurant restaurant;

    public Dish() {
        dishID = 0;
        dishName = "";
        dishPrice = 0;
        dishDescription = "";
        dishCategory = "";
        restaurant = new Restaurant();
    }


    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishID=" + dishID +
                ", dishName='" + dishName + '\'' +
                ", dishPrice=" + dishPrice +
                ", dishDescription='" + dishDescription + '\'' +
                ", dishCategory='" + dishCategory + '\'' +
                '}';
    }
}
