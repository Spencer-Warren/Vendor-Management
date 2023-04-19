package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class VendorDao implements JpaRepository<Vendor, Integer> {
}
