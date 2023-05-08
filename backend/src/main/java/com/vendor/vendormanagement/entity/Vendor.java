package com.vendor.vendormanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Vendor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("vendorId")
    private int vendorID;
    private String vendorName;
    private String vendorUsername;
    private String vendorPassword;
    private String vendorEmail;
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
    @JsonIgnore
    public String getVendorRole() {
        return vendorRole;
    }

    public void setVendorRole(String vendorRole) {
        this.vendorRole = vendorRole;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorID=" + vendorID +
                ", vendorName='" + vendorName + '\'' +
                ", vendorUsername='" + vendorUsername + '\'' +
                ", vendorPassword='" + vendorPassword + '\'' +
                ", vendorEmail='" + vendorEmail + '\'' +
                '}';
    }
    @JsonIgnore
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

    @JsonIgnore
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

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }



}
