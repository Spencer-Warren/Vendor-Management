package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseDao extends JpaRepository<License, Integer> {
    @Query("Select l from License l where l.restaurantID = ?1")
    public abstract License findByRestaurant(int restaurantId);

    @Query("Delete from License l where l.restaurantID = ?1")
    public abstract void deleteByRestaurant(int restaurantId);
}
