package com.banking.api.banking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banking.api.banking_api.model.Role_info;

@Repository
public interface IRoleRepository extends JpaRepository<Role_info, Integer> {
    
}
