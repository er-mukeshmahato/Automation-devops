package com.banking.api.banking_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBasedController {

   // @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }

    //@GetMapping("/user/profile")
    public String userProfile() {
        return "Welcome to the User Profile!";
    }

    //@GetMapping("/common")
    public String commonAccess() {
        return "This is accessible to all authenticated users.";
    }
}