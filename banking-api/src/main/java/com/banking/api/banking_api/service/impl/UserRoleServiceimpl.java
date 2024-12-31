package com.banking.api.banking_api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banking.api.banking_api.dto.UserRoleDTO;
import com.banking.api.banking_api.mapper.RoleMapper;
import com.banking.api.banking_api.model.Role_info;
import com.banking.api.banking_api.model.UserRole_info;
import com.banking.api.banking_api.model.User_info;
import com.banking.api.banking_api.repository.IRoleRepository;
import com.banking.api.banking_api.repository.IUserRepository;
import com.banking.api.banking_api.repository.IUserRoleRepository;
import com.banking.api.banking_api.service.IUserRoleService;

@Service
public class UserRoleServiceimpl implements IUserRoleService {

    private IRoleRepository roleRepository;
    private IUserRepository userRepository;
    private IUserRoleRepository userroleRepository;
    private RoleMapper roleMapper;

    public UserRoleServiceimpl(IRoleRepository roleRepository, IUserRepository userRepository,
            IUserRoleRepository userroleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userroleRepository = userroleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Boolean assignRoletoUser(Integer roleid, Long userid) {
        Optional<Role_info> role = roleRepository.findById(roleid);
        Optional<User_info> user = userRepository.findById(userid);
        if (role.isPresent() && user.isPresent()) {
            UserRoleDTO userrole = new UserRoleDTO();
            userrole.setRoleid(roleid);
            userrole.setUserid(userid);
            userroleRepository.save(roleMapper.mapToUserRole(userrole));

            return true;
        }
        return false;
    }

    @Override
    public Optional<UserRoleDTO> findRoleByUserId(Long id) {
         Optional<UserRole_info> userrole = userroleRepository.findById(id);
          if(userrole != null) {
              return Optional.of(roleMapper.mapToUserRoleDTO(userrole.get()));
          }
            return Optional.empty();
    }

}
