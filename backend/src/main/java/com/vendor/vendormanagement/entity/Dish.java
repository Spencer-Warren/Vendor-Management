package com.vendor.vendormanagement.entity;

import jakarta.persistence.*;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dishID;
    private String dishName;
    private double dishPrice;
    private String dishDescription;
    private String dishCategory;
    @ManyToOne
    @JoinColumn(name="restaurantID")
    private Restaurant restaurant;
}
