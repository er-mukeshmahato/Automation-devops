package com.banking.api.banking_api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Security_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long security_id;
    private Long user_id;
    private int attempts;
    private LocalDateTime last_attempt;
}
