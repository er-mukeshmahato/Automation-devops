package com.banking.api.banking_api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.UserRoleDTO;

@Service
public interface IUserRoleService {
    Boolean assignRoletoUser(Integer roleid,Long userid);
    Optional<UserRoleDTO> findRoleByUserId(Long  id);
}
