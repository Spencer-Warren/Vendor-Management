package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Dish;
import com.vendor.vendormanagement.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Dish newDish(@RequestBody Dish dish) {
        System.out.println(dish);
        return service.saveDish(dish);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public Dish updateDish(@RequestBody Dish dish) {
        return service.updateDish(dish);
    }

    @GetMapping("/{restaurantId}")
    public List<Dish> getAllDishByRestaurant(@PathVariable int restaurantId) {
        return service.findAllByRestaurant(restaurantId);
    }

    @GetMapping("/{restaurantId}/{dishId}")
    public Dish getDish(@PathVariable int restaurantId, @PathVariable int dishId) {
        return service.findByRestaurantAndId(restaurantId, dishId);
    }

    @DeleteMapping("/{restaurantId}")
    @PreAuthorize("hasRole('ROLE_VENDOR')")
    public String deleteDish(@PathVariable int dishId) {
        return service.deleteDish(dishId);
    }

}
