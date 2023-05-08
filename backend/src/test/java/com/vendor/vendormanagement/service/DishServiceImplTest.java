package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.DishDao;
import com.vendor.vendormanagement.entity.Dish;
import com.vendor.vendormanagement.entity.Response;
import com.vendor.vendormanagement.entity.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DishServiceImplTest {

    @InjectMocks
    private DishServiceImpl dishService;

    @Mock
    private DishDao dishDao;

    @Test
    void saveDish() {
        Dish dish = new Dish();
        when(dishDao.save(dish)).thenReturn(dish);

        ResponseEntity<Dish> response = dishService.saveDish(dish);
        Dish actual = response.getBody();

        assertEquals(dish, actual);
        verify(dishDao, times(1)).save(dish);
        verifyNoMoreInteractions(dishDao);
    }

    @Test
    void findByRestaurantAndId() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(10);

        Dish dish = new Dish();
        dish.setDishID(1);
        dish.setRestaurant(restaurant);

        when(dishDao.findByRestaurantAndId(10, 1)).thenReturn(dish);

        ResponseEntity<Dish> response = dishService.findByRestaurantAndId(10,1);
        Dish actual = response.getBody();

        assertEquals(dish, actual);
        verify(dishDao, times(1)).findByRestaurantAndId(10, 1);
        verifyNoMoreInteractions(dishDao);
    }

    @Test
    void updateDish() {
        Dish dish = new Dish();

        ResponseEntity<String> response = dishService.updateDish(dish);
        String actual = response.getBody();

        assertEquals("{\"message\":\"Dish updated successfully\"}", actual);
        verify(dishDao, times(1)).updateDish("", 0, "", "", 0);
        verifyNoMoreInteractions(dishDao);
    }

    @Test
    void deleteDish() {
    }

    @Test
    void findAllByRestaurant() {
    }
}