package com.banking.api.banking_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banking.api.banking_api.model.User_info;

@Repository
public interface IUserRepository extends JpaRepository<User_info, Long> {
    Optional<User_info> findByEmail(String email);
  
}