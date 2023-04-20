package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Integer> {
    @Query("SELECT v FROM Vendor v WHERE v.vendorUsername = ?1")
    public abstract Vendor findByVendorusername(String vendorusername);

    @Query("Select v from Vendor v where v.vendorUsername = ?1 and v.vendorPassword = ?2")
    public abstract Vendor findByVendorusernameAndPassword(String vendorusername, String vendorpassword);
}
