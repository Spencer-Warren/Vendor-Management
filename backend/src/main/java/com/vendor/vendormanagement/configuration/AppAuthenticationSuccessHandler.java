package com.vendor.vendormanagement.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        // ignore
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }

}