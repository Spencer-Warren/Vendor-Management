package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Dish;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DishService {
    public ResponseEntity<Dish> saveDish(Dish dish);
    public ResponseEntity<Dish> findByRestaurantAndId(int restaurantId, int id);
    public ResponseEntity<String> updateDish(Dish dish);
    public ResponseEntity<String> deleteDish(int id);
    public ResponseEntity<List<Dish>> findAllByRestaurant(int restaurantId);
}
