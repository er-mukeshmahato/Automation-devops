package com.banking.api.banking_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.api.banking_api.dto.ApiResponse;
import com.banking.api.banking_api.dto.UserDTO;
import com.banking.api.banking_api.mapper.UserMapper;
import com.banking.api.banking_api.model.User_info;
import com.banking.api.banking_api.service.IUserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        try {
            List<UserDTO> userDTOs = userService.getAllUsers();
            if (userDTOs.isEmpty()) {
                ApiResponse<List<UserDTO>> response = new ApiResponse<>(
                    "success",
                    null,
                    "No users found",
                    null
                );
                return ResponseEntity.ok(response);
            }

            ApiResponse<List<UserDTO>> response = new ApiResponse<>(
                "success",
                userDTOs,
                "Users fetched successfully",
                null
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<List<UserDTO>> response = new ApiResponse<>(
                "error",
                null,
                "An error occurred while fetching users",
                500
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {
        try {
            Optional<UserDTO> user = userService.getUserById(id);

            if (user.isPresent()) {
                ApiResponse<UserDTO> response = new ApiResponse<>(
                        "success",
                        user.get(),
                        "User fetched successfully",
                        null);
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<UserDTO> response = new ApiResponse<>(
                        "error",
                        null,
                        "User not found",
                        404);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ApiResponse<UserDTO> response = new ApiResponse<>(
                "error",
                null,
                "An error occurred while fetching the user",
                500
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> saveOrUpdateUser(
            @PathVariable Long id,
            @RequestBody UserDTO userDTO) {
        try {
            boolean userExists = userService.getUserById(id).isPresent();
            User_info savedUser = userService.saveOrUpdate(id, userDTO); // Save or update the user

            // Create a response with the user data and success message
            String message = userExists ? "User updated successfully" : "User created successfully";
            ApiResponse<UserDTO> response = new ApiResponse<>(
                    "success",
                    savedUser != null ? userMapper.mapToUserDTO(savedUser) : null,
                    message,
                    null);

            HttpStatus status = userExists ? HttpStatus.OK : HttpStatus.CREATED;
            return ResponseEntity.status(status).body(response);
        } catch (Exception e) {
            ApiResponse<UserDTO> response = new ApiResponse<>(
                "error",
                null,
                "An error occurred while saving or updating the user",
                500
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        try {
            boolean deleted = userService.deleteUserById(id);  // Call the service to delete the user
            ApiResponse<Void> response;

            if (deleted) {
                // If user is deleted successfully
                response = new ApiResponse<>(
                    "success", 
                    null, 
                    "User Deleted Successfully", 
                    null
                );
                return ResponseEntity.ok(response);  // Return 204 No Content with response
            } else {
                // If the user was not found and couldn't be deleted
                response = new ApiResponse<>(
                    "error", 
                    null, 
                    "User not found", 
                    404
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);  // Return 404 Not Found with error response
            }
        } catch (Exception e) {
            ApiResponse<Void> response = new ApiResponse<>(
                "error",
                null,
                "An error occurred while deleting the user",
                500
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
