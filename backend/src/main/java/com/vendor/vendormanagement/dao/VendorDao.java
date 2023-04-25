package com.vendor.vendormanagement.dao;

import com.vendor.vendormanagement.entity.Vendor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Vendor v SET v.vendorName = ?1, v.vendorUsername = ?2, v.vendorEmail = ?3 WHERE v.vendorID = ?4")
    public abstract void updateVendor(String vendorname, String vendorusername, String vendoremail, int vendorid);

    @Query("SELECT v FROM Vendor v WHERE v.vendorUsername = ?1")
    public abstract Vendor findByVendorusername(String vendorusername);

    @Query("Select v from Vendor v where v.vendorUsername = ?1 and v.vendorPassword = ?2")
    public abstract Vendor findByVendorusernameAndPassword(String vendorusername, String vendorpassword);
}
