package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "role_info")
public class Role_info {
    @Column(name = "roleid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // You can adjust the strategy based on your database
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
