package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.dao.VendorDao;
import com.vendor.vendormanagement.entity.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VendorServiceImplTest {

    @InjectMocks
    private VendorServiceImpl vendorService;

    @Mock
    private VendorDao vendorDao;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void saveVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorPassword("password");
        when(vendorDao.save(vendor)).thenReturn(vendor);
        when(bCryptPasswordEncoder.encode("password")).thenReturn("passwordEncrypted");

        ResponseEntity<Vendor> response = vendorService.saveVendor(vendor);
        Vendor actual = response.getBody();

        assertEquals(vendor, actual);
        verify(vendorDao, times(1)).save(vendor);
        verifyNoMoreInteractions(vendorDao);
    }

    @Test
    void findByUsername() {
        Vendor vendor = new Vendor();
        vendor.setVendorUsername("username");
        when(vendorDao.findByVendorusername("username")).thenReturn(vendor);

        Vendor actual = vendorService.findByUsername("username");

        assertEquals(vendor, actual);
        verify(vendorDao, times(1)).findByVendorusername("username");
        verifyNoMoreInteractions(vendorDao);
    }

    @Test
    void findByID() {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1);
        when(vendorDao.findById(1)).thenReturn(Optional.of(vendor));

        Vendor actual = vendorService.findByID(1);

        assertEquals(vendor, actual);
        verify(vendorDao, times(1)).findById(1);
        verifyNoMoreInteractions(vendorDao);
    }

    @Test
    void updateVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorName("name");
        vendor.setVendorUsername("username");
        vendor.setVendorPassword("password");
        vendor.setVendorEmail("email");
        vendor.setVendorID(0);

        ResponseEntity<String> response = vendorService.updateVendor(vendor);
        String actual = response.getBody();

        assertEquals("Updated Vendor with ID:0", actual);
        verify(vendorDao, times(1)).updateVendor("name", "username", "email",  0);
        verifyNoMoreInteractions(vendorDao);
    }

    @Test
    void deleteVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1);

        ResponseEntity<String> response = vendorService.deleteVendor(1);
        String actual = response.getBody();

        assertEquals("Deleted Vendor with ID:1", actual);
        verify(vendorDao, times(1)).deleteById(1);
        verifyNoMoreInteractions(vendorDao);
    }

    @Test
    void login() {
        String encodedPassword = bCryptPasswordEncoder.encode("password");

        Vendor vendor = new Vendor();
        vendor.setVendorUsername("username");
        vendor.setVendorPassword(encodedPassword);
        vendor.setVendorID(1);

        when(
                vendorDao.findByVendorusername("username")
            ).thenReturn(vendor);
        when(bCryptPasswordEncoder.matches("password", encodedPassword)).thenReturn(true);

        Vendor loginVendor = new Vendor();
        loginVendor.setVendorUsername("username");
        loginVendor.setVendorPassword("password");

        Vendor actual = vendorService.login(loginVendor);

        assertEquals(vendor, actual);
        verify(vendorDao, times(1)).findByVendorusername("username");
        verifyNoMoreInteractions(vendorDao);
    }
}