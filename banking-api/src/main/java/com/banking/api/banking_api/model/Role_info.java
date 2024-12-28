package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "role_info")
public class Role_info {
    @Column(name = "roleid")
    private int roleid;
    @Column(name = "rolename")
    private String rolename;
    @Column(name = "description")
    private String description;
    @Column(updatable = false, name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

}
