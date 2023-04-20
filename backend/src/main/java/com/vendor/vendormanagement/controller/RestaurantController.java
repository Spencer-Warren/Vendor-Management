package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Restaurant;
import com.vendor.vendormanagement.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService service;

    @PostMapping("/")
    public Restaurant newRestaurant(@RequestBody Restaurant restaurant) {
        return service.saveRestaurant(restaurant);
    }

    @PutMapping("/")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return service.updateRestaurant(restaurant);
    }

    @GetMapping("/{vendorId}")
    public List<Restaurant> getAllRestaurantByVendor(@PathVariable int vendorId) {
        return service.findAllByVendor(vendorId);
    }

    @GetMapping("/{vendorId}/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable int restaurantId) {
        return service.findByID(restaurantId);
    }

    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable int restaurantId) {
        return service.deleteRestaurant(restaurantId);
    }
}
