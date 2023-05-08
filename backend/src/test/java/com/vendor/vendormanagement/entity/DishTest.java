package com.vendor.vendormanagement.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {

    @Test
    void setDishID() {
        Dish dish = new Dish();
        dish.setDishID(1);
        assertEquals(1, dish.getDishID());
    }

    @Test
    void setDishName() {
        Dish dish = new Dish();
        dish.setDishName("Dish Name");
        assertEquals("Dish Name", dish.getDishName());
    }

    @Test
    void setDishPrice() {
        Dish dish = new Dish();
        dish.setDishPrice(1.0);
        assertEquals(1.0, dish.getDishPrice());
    }

    @Test
    void setDishDescription() {
        Dish dish = new Dish();
        dish.setDishDescription("Dish Description");
        assertEquals("Dish Description", dish.getDishDescription());
    }

    @Test
    void setDishCategory() {
        Dish dish = new Dish();
        dish.setDishCategory("Dish Category");
        assertEquals("Dish Category", dish.getDishCategory());
    }

    @Test
    void setRestaurant() {
        Dish dish = new Dish();
        Restaurant restaurant = new Restaurant();
        dish.setRestaurant(restaurant);
        assertEquals(restaurant, dish.getRestaurant());
    }

    @Test
    void testToString() {
        Dish dish = new Dish();
        dish.setDishID(1);
        dish.setDishName("Dish Name");
        dish.setDishPrice(1.0);
        dish.setDishDescription("Dish Description");
        dish.setDishCategory("Dish Category");
        Restaurant restaurant = new Restaurant();
        dish.setRestaurant(restaurant);
        assertEquals("Dish{dishID=1, dishName='Dish Name', dishPrice=1.0, dishDescription='Dish Description', dishCategory='Dish Category'}", dish.toString());
    }
}