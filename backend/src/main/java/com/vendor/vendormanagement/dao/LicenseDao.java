package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class LicenseDao implements JpaRepository<License, Integer> {
}
