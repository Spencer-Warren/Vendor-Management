package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.ResturantDao;
import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    ResturantDao dao;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return dao.save(restaurant);
    }

    @Override
    public Restaurant findByID(int id) {
        return dao.findById(id).orElseGet(Restaurant::new);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return dao.save(restaurant);
    }

    @Override
    public String deleteRestaurant(int id) {
        dao.deleteById(id);
        return "Deleted Restaurant with ID:" + id;
    }

    @Override
    public List<Restaurant> findAllByVendor(int vendorId) {
        return dao.findAllByVendor(vendorId);
    }

}
