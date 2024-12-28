package com.banking.api.banking_api.mapper;

import org.springframework.stereotype.Component;

import com.banking.api.banking_api.dto.UserDTO;
import com.banking.api.banking_api.model.User_info;

@Component
public class UserMapper {

    // Method to convert a User entity to a UserDTO
    public UserDTO mapToUserDTO(User_info user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    // If needed, you can also create a reverse method to map DTO back to entity
    public User_info mapToUser(UserDTO userDTO) {
        User_info user = new User_info();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
