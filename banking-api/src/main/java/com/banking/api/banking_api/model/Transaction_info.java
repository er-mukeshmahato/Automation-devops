package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction_info {
    private Long transaction_id;
    private Long user_id;
    private LocalDateTime created_date;
    private double amount;
    private String transaction_type;
    private Long account_id;
    private String description;
    private String status;

}
