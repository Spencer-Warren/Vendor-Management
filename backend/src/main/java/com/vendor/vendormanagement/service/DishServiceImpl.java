package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.DishDao;
import com.vendor.vendormanagement.entity.Dish;
import com.vendor.vendormanagement.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishDao dao;

    @Override
    public ResponseEntity<Dish> saveDish(Dish dish) {
        return Response.of(dao.save(dish), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Dish> findByRestaurantAndId(int restaurantId, int id) {
        return Response.of(dao.findByRestaurantAndId(restaurantId, id));
    }

    @Override
    public ResponseEntity<String> updateDish(Dish dish) {
        dao.updateDish(dish.getDishName(), dish.getDishPrice(), dish.getDishDescription(), dish.getDishCategory(), dish.getDishID());
        return Response.of("Dish updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteDish(int id) {
        dao.deleteById(id);
        return Response.of("Dish deleted successfully");
    }

    @Override
    public ResponseEntity<List<Dish>> findAllByRestaurant(int restaurantId) {
        return Response.of(dao.findAllByRestaurant(restaurantId));
    }
}
