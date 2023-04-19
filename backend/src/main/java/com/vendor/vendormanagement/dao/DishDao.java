package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DishDao implements JpaRepository<Dish, Integer> {
}
