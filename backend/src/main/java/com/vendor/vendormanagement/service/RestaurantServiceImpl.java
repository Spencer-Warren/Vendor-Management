package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.LicenseDao;
import com.vendor.vendormanagement.dao.RestaurantDao;
import com.vendor.vendormanagement.entity.License;
import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDao dao;

    @Autowired
    LicenseDao licenseDao;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return dao.save(restaurant);
    }

    @Override
    public Restaurant findByID(int vendorId, int id) {
        return dao.findByVendorAndId(vendorId, id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return dao.save(restaurant);
    }

    @Override
    public String deleteRestaurant(int id) {
        dao.deleteById(id);
//        licenseDao.deleteByRestaurant(id);
        return "Deleted Restaurant with ID:" + id;
    }

    @Override
    public List<Restaurant> findAllByVendor(int vendorId) {
        return dao.findAllByVendor(vendorId);
    }

}
