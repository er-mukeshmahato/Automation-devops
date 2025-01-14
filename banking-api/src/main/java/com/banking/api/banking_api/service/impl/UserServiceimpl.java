package com.banking.api.banking_api.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.api.banking_api.constant.roleConstants;
import com.banking.api.banking_api.dto.UserDTO;
import com.banking.api.banking_api.helper.PasswordHasher;
import com.banking.api.banking_api.mapper.UserMapper;
import com.banking.api.banking_api.model.User_info;
import com.banking.api.banking_api.repository.IUserRepository;
import com.banking.api.banking_api.service.IUserRoleService;
import com.banking.api.banking_api.service.IUserService;

@Service
public class UserServiceimpl implements IUserService {

    private IUserRepository userRepository;
    private UserMapper userMapper;
    private PasswordHasher passwordHasher;
    private IUserRoleService userRoleService;

    @Autowired
    public void UserServiceImpl(IUserRepository userRepository, UserMapper userMapper,PasswordHasher passwordHasher,IUserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordHasher = passwordHasher;
        this.userRoleService = userRoleService;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User_info> users = userRepository.findAll(); // Fetch all users from the repository
        return users.stream()
                .map(userMapper::mapToUserDTO) // Convert entities to DTOs
                .collect(Collectors.toList());
    }

    @Override
    public User_info saveOrUpdate(Long id, UserDTO userDTO) {
        // Fetch the existing user by ID
        Optional<User_info> existingUser = userRepository.findById(id);
    
        // Check if the user exists
        if (existingUser.isPresent()) {
            // User exists, update their information
            User_info user = existingUser.get();  // Retrieve the existing user
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(passwordHasher.hashPassword(userDTO.getPassword()));  // Hash the password
            user.setUpdated_at(LocalDateTime.now());  // Set the updated timestamp (if needed)
    
            return userRepository.save(user);  // Save the updated user
        } else {
            // If user does not exist, create a new user
            User_info user = new User_info();
            user.setId(id);  // Set the provided ID, so it doesn't get treated as a new entity
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(passwordHasher.hashPassword(userDTO.getPassword()));  // Hash the password
            user.setCreated_at(LocalDateTime.now());  // Set the created timestamp
            User_info userdetails= userRepository.save(user);
            if(userdetails!=null){
                userRoleService.assignRoletoUser(roleConstants.User, userdetails.getId());
            }
            
          
            return userdetails;  // Save the new user
        }
    }
    

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User_info> existingUser = userRepository.findById(id);
        
        if (existingUser.isPresent()) {
            UserDTO userDTO = userMapper.mapToUserDTO(existingUser.get());
            return Optional.of(userDTO);
        } else {
            return Optional.empty();  // Return an empty Optional if the user is not found
        }
    }

    @Override
    public boolean deleteUserById(long id) {
        Optional<User_info> existingUserOptional = userRepository.findById(id);
        
        if (existingUserOptional.isPresent()) {
            // If user exists, delete them
            userRepository.delete(existingUserOptional.get());
            return true;  // Return true to indicate successful deletion
        } else {
            // User not found
            return false;  // Return false if the user doesn't exist
        }
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
       Optional<User_info> existingOptional= userRepository.findByEmail(email);
         if(existingOptional.isPresent()) {
              UserDTO userDTO = userMapper.mapToUserDTO(existingOptional.get());
              return Optional.of(userDTO);
         }
         else {
              return Optional.empty();
         }
    }

   

}
