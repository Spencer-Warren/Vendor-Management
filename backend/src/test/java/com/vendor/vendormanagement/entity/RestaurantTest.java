package com.vendor.vendormanagement.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void setRestaurantID() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(1);
        assertEquals(restaurant.getRestaurantID(), 1);
    }

    @Test
    void setRestaurantName() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("name");
        assertEquals(restaurant.getRestaurantName(), "name");
    }

    @Test
    void setRestaurantAddress() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantAddress("address");
        assertEquals(restaurant.getRestaurantAddress(), "address");
    }

    @Test
    void setRestaurantType() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantType("type");
        assertEquals(restaurant.getRestaurantType(), "type");
    }

    @Test
    void setRestaurantCategory() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantCategory("category");
        assertEquals(restaurant.getRestaurantCategory(), "category");
    }

    @Test
    void setRestaurantDescription() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantDescription("description");
        assertEquals(restaurant.getRestaurantDescription(), "description");
    }

    @Test
    void setRestaurantEmail() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantEmail("email");
        assertEquals(restaurant.getRestaurantEmail(), "email");
    }

    @Test
    void setRestaurantPhone() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantPhone("111-111-1111");
        assertEquals(restaurant.getRestaurantPhone(), "111-111-1111");
    }

    @Test
    void setVendor() {
        Restaurant restaurant = new Restaurant();
        Vendor vendor = new Vendor();
        restaurant.setVendor(vendor);
        assertEquals(restaurant.getVendor(), vendor);
    }

    @Test
    void setDishes() {
        Restaurant restaurant = new Restaurant();
        restaurant.setDishes(null);
        assertEquals(restaurant.getDishes(), null);
    }

    @Test
    void testToString() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(1);
        restaurant.setRestaurantName("name");
        restaurant.setRestaurantAddress("address");
        restaurant.setRestaurantType("type");
        restaurant.setRestaurantCategory("category");
        restaurant.setRestaurantDescription("description");
        restaurant.setRestaurantEmail("email");
        restaurant.setRestaurantPhone("111-111-1111");
        Vendor vendor = new Vendor();
        restaurant.setVendor(vendor);
        assertEquals(restaurant.toString(), "Restaurant{restaurantID=1, restaurantName='name', restaurantAddress='address', restaurantType='type', restaurantCategory='category', restaurantDescription='description', restaurantEmail='email', restaurantPhone='111-111-1111'}");
    }
}