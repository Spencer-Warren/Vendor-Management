package com.vendor.vendormanagement.controller;

import com.vendor.vendormanagement.entity.Dish;
import com.vendor.vendormanagement.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService service;

    @PostMapping("")
    public Dish newDish(@RequestBody Dish dish) {
        System.out.println(dish);
        return service.saveDish(dish);
    }

    @PutMapping("")
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
    public String deleteDish(@PathVariable int dishId) {
        return service.deleteDish(dishId);
    }

}
