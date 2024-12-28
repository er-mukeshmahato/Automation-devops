package com.banking.api.banking_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_role")
public class UserRole_info {
    @Column(name = "id")
    private Long id;
    @Column(name = "roleid")
    private int roleid;
    @Column(name = "userid")
    private Long userid;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private String updated_at;

}
