package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Restaurant;
import com.vendor.vendormanagement.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService service;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public Restaurant newRestaurant(@RequestBody Restaurant restaurant) {
        return service.saveRestaurant(restaurant);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return service.updateRestaurant(restaurant);
    }

    @GetMapping("/{vendorId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public List<Restaurant> getAllRestaurantByVendor(@PathVariable int vendorId) {
        return service.findAllByVendor(vendorId);
    }

    @GetMapping("/{vendorId}/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable int vendorId, @PathVariable int restaurantId) {
        return service.findByID(vendorId, restaurantId);
    }

    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable int restaurantId) {
        return service.deleteRestaurant(restaurantId);
    }
}
