package com.banking.api.banking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.api.banking_api.model.UserRole_info;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole_info, Long> {


}
