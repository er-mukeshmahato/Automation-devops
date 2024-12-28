package com.banking.api.banking_api.mapper;

import org.springframework.stereotype.Component;

import com.banking.api.banking_api.dto.RoleDTO;
import com.banking.api.banking_api.dto.UserRoleDTO;
import com.banking.api.banking_api.model.Role_info;
import com.banking.api.banking_api.model.UserRole_info;

@Component
public class RoleMapper {

    public RoleDTO mapToRoleDTO(Role_info role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleid(role.getRoleid());
        roleDTO.setRolename(role.getRolename());
        roleDTO.setDescription(role.getDescription());
        roleDTO.setCreated_at(role.getCreated_at());
        roleDTO.setUpdated_at(role.getUpdated_at());
        return roleDTO;
    }

    public Role_info mapToRole(RoleDTO roleDTO) {
        Role_info role = new Role_info();
        role.setRoleid(roleDTO.getRoleid());
        role.setRolename(roleDTO.getRolename());
        role.setDescription(roleDTO.getDescription());
        role.setCreated_at(roleDTO.getCreated_at());
        role.setUpdated_at(roleDTO.getUpdated_at());
        return role;
    }
    public UserRole_info mapToUserRole(UserRoleDTO userroleDTO) {
        UserRole_info userrole = new UserRole_info();
        userrole.setRoleid(userroleDTO.getRoleid());
        userrole.setUserid(userroleDTO.getUserid());
        userrole.setCreated_at(userroleDTO.getCreated_at());
        userrole.setUpdated_at(userroleDTO.getUpdated_at());
        return userrole;
    }

    public UserRoleDTO mapToUserRoleDTO(UserRole_info userrole) {
        UserRoleDTO userroleDTO = new UserRoleDTO();
        userroleDTO.setRoleid(userrole.getRoleid());
        userroleDTO.setUserid(userrole.getUserid());
        userroleDTO.setCreated_at(userrole.getCreated_at());
        userroleDTO.setUpdated_at(userrole.getUpdated_at());
        return userroleDTO;
    }

}
