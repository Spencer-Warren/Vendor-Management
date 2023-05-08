package com.vendor.vendormanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendor.vendormanagement.entity.Vendor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // JUnit4
@WebMvcTest(VendorController.class)
public class VendorControllerTest {

    @Mock
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VendorController vendorController;

//    @BeforeEach
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
//    }

    private Vendor getPlainVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1);
        vendor.setVendorName("name");
        vendor.setVendorUsername("username");
        vendor.setVendorPassword("password");
        vendor.setVendorName("name");
        vendor.setVendorEmail("email");
        return vendor;
    }

    private static String asJsonString(Vendor vendor) {
        try {
            return new ObjectMapper().writeValueAsString(vendor);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void testNewVendor() throws Exception {
        Vendor vendor = getPlainVendor();

        mockMvc.perform(
                post("/api/register").content(asJsonString(vendor))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.vendorID").value(vendor.getVendorID()));
    }




}