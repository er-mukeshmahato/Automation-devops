package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Account_info {
    private Long account_id;
    private Long user_id;
    private String account_type;
    private double balance;
    private String currency;
    private LocalDateTime created_at;
    private String status;
}
