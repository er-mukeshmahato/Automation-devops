package com.banking.api.banking_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.banking.api.banking_api.dto.UserDTO;
import com.banking.api.banking_api.model.User_info;

@Service
public interface IUserService {

    List<UserDTO> getAllUsers();

    User_info saveOrUpdate(Long id, UserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    boolean deleteUserById(long id);

    Optional<UserDTO> getUserByEmail(String email);

  
}
