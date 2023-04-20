package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.entity.Dish;

import java.util.List;

public interface DishService {
    public Dish saveDish(Dish dish);
    public Dish findByRestaurantAndId(int restaurantId, int id);
    public Dish updateDish(Dish dish);
    public String deleteDish(int id);
    public List<Dish> findAllByRestaurant(int restaurantId);
}
