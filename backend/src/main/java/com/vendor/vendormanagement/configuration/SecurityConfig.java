package com.vendor.vendormanagement.configuration;

import com.vendor.vendormanagement.service.VendorDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService userDetailsService() {return new VendorDetailsService();}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/api/register", "/api/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin(form ->
//                        form.loginPage("/api/login")
//                                .permitAll()
//                )
                // temp for dev
                .anyRequest().permitAll()
                .and()
                .build();
    }
}
