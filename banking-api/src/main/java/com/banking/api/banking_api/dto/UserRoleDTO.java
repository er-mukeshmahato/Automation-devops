package com.banking.api.banking_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private int roleid;
    private Long userid;
    private String created_at;
    private String updated_at;

}
