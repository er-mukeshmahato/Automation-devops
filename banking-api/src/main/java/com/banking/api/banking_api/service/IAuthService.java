package com.banking.api.banking_api.service;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.LoginDTO;

@Service
public interface IAuthService {

   LoginDTO getUserDetail(String username);
   


}
