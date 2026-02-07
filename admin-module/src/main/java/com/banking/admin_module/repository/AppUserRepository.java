package com.banking.admin_module.repository;

import com.banking.admin_module.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByLoginName(String loginName);
    List<AppUser> findByBank_Id(Long bankId);
    List<AppUser> findByBranch_Id(Long branchId);
    List<AppUser> findByBlockStatus(String blockStatus);
    List<AppUser> findByIsActiveFlag(String isActiveFlag);
}