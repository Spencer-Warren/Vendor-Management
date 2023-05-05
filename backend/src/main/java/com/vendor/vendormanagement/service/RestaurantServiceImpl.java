package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.LicenseDao;
import com.vendor.vendormanagement.dao.RestaurantDao;
import com.vendor.vendormanagement.entity.Response;
import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDao dao;

    @Autowired
    LicenseDao licenseDao;

    @Override
    public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant) {
        return Response.of(dao.save(restaurant), HttpStatus.CREATED);
    }

    @Override
    public Restaurant findByID(int vendorId, int id) {
        return dao.findByVendorAndId(vendorId, id);
    }

    @Override
    public ResponseEntity<String> updateRestaurant(Restaurant restaurant) {
        dao.updateRestaurant(restaurant.getRestaurantName(), restaurant.getRestaurantAddress(), restaurant.getRestaurantPhone(), restaurant.getRestaurantCategory(), restaurant.getRestaurantEmail(), restaurant.getRestaurantDescription(), restaurant.getRestaurantID());
        return Response.of("Restaurant updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteRestaurant(int id) {
        dao.deleteById(id);
        return Response.of("Restaurant deleted successfully");
    }

    @Override
    public List<Restaurant> findAllByVendor(int vendorId) {
        return dao.findAllByVendor(vendorId);
    }

}
