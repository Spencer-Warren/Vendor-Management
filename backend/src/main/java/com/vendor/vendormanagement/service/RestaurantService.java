package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant);
    public Restaurant findByID(int vendorId, int id);
    public ResponseEntity<String> updateRestaurant(Restaurant restaurant);
    public ResponseEntity<String> deleteRestaurant(int id);
    public List<Restaurant> findAllByVendor(int vendorId);
}
