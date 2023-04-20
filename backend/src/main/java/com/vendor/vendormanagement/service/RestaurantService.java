package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant saveRestaurant(Restaurant restaurant);
    public Restaurant findByID(int vendorId, int id);
    public Restaurant updateRestaurant(Restaurant restaurant);
    public String deleteRestaurant(int id);
    public List<Restaurant> findAllByVendor(int vendorId);
}
