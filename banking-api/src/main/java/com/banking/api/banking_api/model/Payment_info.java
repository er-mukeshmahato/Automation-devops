package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment_info {
    private Long payment_id;
    private Long user_id;
    private double amount;
    private String biller_name;
    private LocalDateTime payment_date;
    private String status;

}
