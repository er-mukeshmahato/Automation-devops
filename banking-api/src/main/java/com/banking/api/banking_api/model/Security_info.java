package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Security_info {

    private Long security_id;
    private Long user_id;
    private int attempts;
    private LocalDateTime last_attempt;
}
