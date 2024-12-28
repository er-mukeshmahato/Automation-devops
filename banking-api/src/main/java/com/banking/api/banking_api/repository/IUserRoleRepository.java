package com.banking.api.banking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.api.banking_api.model.UserRole_info;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole_info, Long> {
   
      @Query("SELECT u FROM UserRole_info u WHERE u.user_id = :id")
      UserRole_info findRoleByUserId(@Param("id") Long id);
}
