package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Dish;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishDao extends JpaRepository<Dish, Integer> {
    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = ?1")
    public abstract List<Dish> findAllByRestaurant(int restaurantId);
    
    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = ?1 AND d.id = ?2")
    public abstract Dish findByRestaurantAndId(int restaurantId, int id);

    @Transactional
    @Modifying
    @Query("UPDATE Dish d SET d.dishName = ?1, d.dishPrice = ?2, d.dishDescription = ?3, d.dishCategory = ?4 WHERE d.id = ?5")
    public abstract void updateDish(String dishName, double dishPrice, String dishDescription, String dishCategory, int dishId);
}
