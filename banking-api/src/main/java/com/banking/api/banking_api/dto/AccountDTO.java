package com.banking.api.banking_api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccountDTO {
    private Long accountid;
    private Long userID;
    private String account_type;
    private double balance;
    private String currency;
    private LocalDateTime created_at;
    private String status;

}
