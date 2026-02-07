package com.banking.admin_module.repository;

import com.banking.admin_module.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, String> {
    List<UserGroup> findByUserId(String userId);
    List<UserGroup> findByGroupId(String groupId);
    List<UserGroup> findByStatus(String status);
}