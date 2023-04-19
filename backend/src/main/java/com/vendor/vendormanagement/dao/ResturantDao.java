package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class ResturantDao implements JpaRepository<Resturant, Integer> {
}
