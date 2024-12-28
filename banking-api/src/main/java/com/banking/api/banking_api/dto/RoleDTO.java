package com.banking.api.banking_api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private int roleid;
    private String rolename;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
