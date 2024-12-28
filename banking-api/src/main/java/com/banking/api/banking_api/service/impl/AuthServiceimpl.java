package com.banking.api.banking_api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.LoginDTO;
import com.banking.api.banking_api.dto.RoleDTO;
import com.banking.api.banking_api.dto.UserDTO;
import com.banking.api.banking_api.dto.UserRoleDTO;

import com.banking.api.banking_api.service.IAuthService;
import com.banking.api.banking_api.service.IRoleService;
import com.banking.api.banking_api.service.IUserRoleService;
import com.banking.api.banking_api.service.IUserService;

@Service
public class AuthServiceimpl implements IAuthService {

    private IUserService userService;
    private IUserRoleService userroleService;
    private IRoleService roleService;


    public AuthServiceimpl(IUserService userService, IUserRoleService userroleService, IRoleService roleService) {
        this.userService = userService;
        this.userroleService = userroleService;
        this.roleService = roleService;
    
    }

    @Override
    public LoginDTO getUserDetail(String username) {
        // Retrieve user details by email (username in this case)
        Optional<UserDTO> existingDetails = userService.getUserByEmail(username);
        Optional<UserRoleDTO> existingRole = userroleService.findRoleByUserId(existingDetails.get().getId());
        Optional<RoleDTO> roleDetail= roleService.getRoleByUserId(existingRole.get().getRoleid());

        // If user is present, check if the password matches
        if (existingDetails.isPresent()) {
            UserDTO userDTO = existingDetails.get();
            LoginDTO userLoginDTO = new LoginDTO();
            userLoginDTO.setUsername(userDTO.getName());
            userLoginDTO.setPassword(userDTO.getPassword());
            userLoginDTO.setRoles(roleDetail.get().getRolename());
            return userLoginDTO;
            
        }

        return null;
    }


}
