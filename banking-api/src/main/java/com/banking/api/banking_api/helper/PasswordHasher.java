package com.banking.api.banking_api.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class PasswordHasher {

    public String passwordToHash(String password) {
        return get_SHA_256_SecurePassword(password);
    }

    public String hashPassword(String password) {
        return passwordToHash(password);
    }

    public boolean authenticatePassword(String enteredPassword, String storedHashedPassword) {
        String hashedEnteredPassword = passwordToHash(enteredPassword);
        return storedHashedPassword.equals(hashedEnteredPassword);
    }

    private static String get_SHA_256_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(String.format("%02x", aByte));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
        return generatedPassword;
    }
}