package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
    @Query("Select r from Restaurant r where r.vendor.id = ?1")
    public abstract List<Restaurant> findAllByVendor(int vendorId);

    @Query("Select r from Restaurant r where r.vendor.id = ?1 and r.id = ?2")
    public abstract Restaurant findByVendorAndId(int vendorId, int id);
}
