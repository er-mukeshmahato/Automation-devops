package com.banking.api.banking_api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO  {
    private String username;
    private String password;
    //private Collection<? extends GrantedAuthority> roles; // User roles/permissions
    private String roles;
}
