package com.banking.api.banking_api.filter;

import com.banking.api.banking_api.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private com.banking.api.banking_api.util.JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String token = request.getHeader("Authorization");
                if (token != null && token.startsWith("Bearer ")) {
                    token = token.substring(7);
                    String username = jwtUtil.extractUsername(token);
                    if (username != null && jwtUtil.isTokenValid(token, username)) {
                        // You can store user details in the request to access later if needed
                        request.setAttribute("username", username);
                       
                    }
                }
        
                filterChain.doFilter(request, response);
    }
}
