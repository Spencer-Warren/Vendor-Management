package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResturantDao extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT R FROM restaurant R WHERE R.vendor.id = ?1")
    public abstract List<Restaurant> findAllByVendor(int vendorId);

}
