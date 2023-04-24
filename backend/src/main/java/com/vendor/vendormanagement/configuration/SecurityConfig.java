package com.vendor.vendormanagement.configuration;

import com.vendor.vendormanagement.service.VendorDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService userDetailsService() {return new VendorDetailsService();}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/register", "/api/login").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/login")
                .usernameParameter("vendorUsername")
                .passwordParameter("vendorPassword")
                .successHandler(appAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .and()
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }

}
