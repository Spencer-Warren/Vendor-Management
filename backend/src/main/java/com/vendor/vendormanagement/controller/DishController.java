package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Dish;
import com.vendor.vendormanagement.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService service;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<Dish> newDish(@RequestBody Dish dish) {
        return service.saveDish(dish);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<String> updateDish(@RequestBody Dish dish) {
        return service.updateDish(dish);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Dish>> getAllDishByRestaurant(@PathVariable int restaurantId) {
        return service.findAllByRestaurant(restaurantId);
    }

    @GetMapping("/{restaurantId}/{dishId}")
    public ResponseEntity<Dish> getDish(@PathVariable int restaurantId, @PathVariable int dishId) {
        return service.findByRestaurantAndId(restaurantId, dishId);
    }

    @DeleteMapping("/{dishId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public ResponseEntity<String> deleteDish(@PathVariable int dishId) {
        return service.deleteDish(dishId);
    }

}
