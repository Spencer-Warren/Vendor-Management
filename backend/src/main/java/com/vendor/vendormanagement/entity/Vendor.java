package com.vendor.vendormanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Vendor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vendorID;
    private String vendorName;
    private String vendorUsername;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String vendorPassword;
    private String vendorEmail;
    @JsonIgnore
    private String vendorRole;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Restaurant> restaurants;

    public Vendor() {
        vendorID = 0;
        vendorName = "";
        vendorUsername = "";
        vendorPassword = "";
        vendorEmail = "";
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public void setVendorUsername(String username) {
        this.vendorUsername = username;
    }

    public String getVendorUsername() {
        return vendorUsername;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String password) {
        this.vendorPassword = password;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorRole() {
        return vendorRole;
    }

    public void setVendorRole(String vendorRole) {
        this.vendorRole = vendorRole;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "VendorID=" + vendorID +
                ", VendorName='" + vendorName + '\'' +
                ", VendorUsername='" + vendorUsername + '\'' +
                ", VendorPassword='" + vendorPassword + '\'' +
                ", VendorEmail='" + vendorEmail + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (vendorRole == null) {
            return List.of();
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(vendorRole);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return vendorPassword;
    }
    public void setPassword(String encode) {
        this.vendorPassword = encode;
    }

    @Override
    public String getUsername() {
        return vendorUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
