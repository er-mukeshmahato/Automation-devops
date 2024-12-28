package com.banking.api.banking_api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session_info {
    private Long session_id;
    private Long user_id;
    private LocalDateTime login_time;
    private LocalDateTime logout_time;
    

}
