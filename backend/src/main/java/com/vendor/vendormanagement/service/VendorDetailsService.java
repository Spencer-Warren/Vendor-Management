package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.VendorDao;
import com.vendor.vendormanagement.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VendorDetailsService implements UserDetailsService {
    @Autowired
    private VendorDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Vendor vendor = dao.findByVendorusername(username);
        if (vendor == null) {
            throw new UsernameNotFoundException("User not found");
        }
       return vendor;
    }
}
