package com.banking.api.banking_api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.RoleDTO;

import com.banking.api.banking_api.mapper.RoleMapper;
import com.banking.api.banking_api.model.Role_info;
import com.banking.api.banking_api.repository.IRoleRepository;
import com.banking.api.banking_api.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {

    private IRoleRepository roleRepository;
    private RoleMapper roleMapper;

    public RoleServiceImpl(IRoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        
    }

    @Override
    public Role_info addOrUpdate(Integer roleid,RoleDTO roleDto) {
       Optional<Role_info> roledetails = roleRepository.findById(roleid);
       if (roledetails.isPresent()) {
           Role_info role = roledetails.get();
           role.setRolename(roleDto.getRolename());
           role.setDescription(roleDto.getDescription());
           return roleRepository.save(role);
        
       }
       else {
           Role_info role = new Role_info();
           role.setRoleid(0);
           role.setRolename(roleDto.getRolename());
           role.setDescription(roleDto.getDescription());
           return roleRepository.save(role); 
       }   

    }

    @Override
    public boolean deleteRole(int roleid) {
        Optional<Role_info> roledetails = roleRepository.findById(roleid);
        if (roledetails.isPresent()) {
            roleRepository.deleteById(roleid);
            return true;
            
        }
        return false;
    }

    @Override
    public List<RoleDTO> getallRole() {
        List<Role_info> roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::mapToRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDTO> getRoleByUserId(Integer roleid) {
        Optional<Role_info> role = roleRepository.findById(roleid);
        if (role.isPresent()) {
            return Optional.of(roleMapper.mapToRoleDTO(role.get()));
        }
        return Optional.empty();
    }

    

}
