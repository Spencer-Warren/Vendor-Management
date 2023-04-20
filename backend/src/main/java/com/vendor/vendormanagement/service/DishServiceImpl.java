package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.DishDao;
import com.vendor.vendormanagement.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishDao dao;

    @Override
    public Dish saveDish(Dish dish) {
        return dao.save(dish);
    }

    @Override
    public Dish findByRestaurantAndId(int restaurantId, int id) {
        return dao.findByRestaurantAndId(restaurantId, id);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dao.save(dish);
    }

    @Override
    public String deleteDish(int id) {
        dao.deleteById(id);
        return "Deleted Dish with ID: " + id;
    }

    @Override
    public List<Dish> findAllByRestaurant(int restaurantId) {
        return dao.findAllByRestaurant(restaurantId);
    }
}
