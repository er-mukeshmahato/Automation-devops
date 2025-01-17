package com.banking.api.banking_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.api.banking_api.dto.ApiResponse;
import com.banking.api.banking_api.dto.LoginDTO;
import com.banking.api.banking_api.helper.PasswordHasher;
import com.banking.api.banking_api.service.IAuthService;
import com.banking.api.banking_api.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;
    private final PasswordHasher passwordHasher;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(IAuthService authService, PasswordHasher passwordHasher, JwtUtil jwtUtil) {
        this.authService = authService;
        this.passwordHasher = passwordHasher;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDTO loginDTO) {
        try {
            // Step 1: Get the user details from the auth service
            LoginDTO user = authService.getUserDetail(loginDTO.getUsername());

            if (user == null) {
                // User not found
                ApiResponse<String> response = new ApiResponse<>(
                        "error",
                        null,
                        "User not found",
                        404);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            // Step 2: Authenticate the password using the stored hashed password
            boolean isValid = passwordHasher.authenticatePassword(loginDTO.getPassword(), user.getPassword());

            if (!isValid) {
                // Invalid password
                ApiResponse<String> response = new ApiResponse<>(
                        "error",
                        null,
                        "Unauthorized: Incorrect password",
                        401);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Step 3: Generate JWT token
            String token = jwtUtil.generateToken(user.getUsername());

            if (token == null || token.isEmpty()) {
                // JWT generation failed
                ApiResponse<String> response = new ApiResponse<>(
                        "error",
                        null,
                        "Failed to generate JWT token",
                        500);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            // Step 4: Return success response with token
            ApiResponse<String> response = new ApiResponse<>(
                    "success",
                    token,
                    "Login successful",
                    null);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // General exception handling
            ApiResponse<String> response = new ApiResponse<>(
                    "error",
                    null,
                    "An error occurred during the login process: " + e.getMessage(),
                    500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
