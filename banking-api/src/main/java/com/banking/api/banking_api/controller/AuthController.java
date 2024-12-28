package com.banking.api.banking_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.api.banking_api.dto.LoginDTO;
import com.banking.api.banking_api.helper.PasswordHasher;
import com.banking.api.banking_api.service.IAuthService;
import com.banking.api.banking_api.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;
    private final PasswordHasher passwordHasher;
    @Autowired
    public AuthController(IAuthService authService, PasswordHasher passwordHasher) {
        this.authService = authService;
        this.passwordHasher = passwordHasher;
    }

   @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String hashPassword= passwordHasher.hashPassword(password);
        boolean isvalid=passwordHasher.authenticatePassword(password,hashPassword);
        LoginDTO user = authService.getUserDetail(username);
        if (isvalid) {
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);  // Return JWT token
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
    

}
