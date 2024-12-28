package com.banking.api.banking_api.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String username;
    private String role;
    private String jwtToken;

}
