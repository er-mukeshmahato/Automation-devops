package com.banking.api.banking_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private String status;
    private T data;
    private String message;
    private Object error;
}
