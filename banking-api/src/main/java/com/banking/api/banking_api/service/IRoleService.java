package com.banking.api.banking_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.RoleDTO;
import com.banking.api.banking_api.model.Role_info;


@Service
public interface IRoleService {

    
    Role_info addOrUpdate(Integer roleid,RoleDTO roleDto);
    boolean deleteRole(int roleid);
    List<RoleDTO> getallRole();
    Optional<RoleDTO> getRoleByUserId(Integer roleid);
   


}
