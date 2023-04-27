package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
    @Query("Select r from Restaurant r where r.vendor.id = ?1")
    public abstract List<Restaurant> findAllByVendor(int vendorId);

    @Query("Select r from Restaurant r where r.vendor.id = ?1 and r.id = ?2")
    public abstract Restaurant findByVendorAndId(int vendorId, int id);

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.restaurantName = ?1, r.restaurantAddress = ?2, r.restaurantPhone = ?3, r.restaurantCategory = ?4, r.restaurantEmail = ?5, r.restaurantDescription = ?6 WHERE r.id = ?7")
    public abstract void updateRestaurant(String restaurantname, String restaurantaddress, String restaurantphone, String restaurantcategory, String restaurantemail, String restaurantDescription, int restaurantid);

}
