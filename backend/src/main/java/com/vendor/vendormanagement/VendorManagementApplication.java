package com.vendor.vendormanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vendor.vendormanagement")
public class VendorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorManagementApplication.class, args);
	}

}
