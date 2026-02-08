package com.banking.admin_module.repository;

import com.banking.admin_module.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findByGroupId(String groupId);
    List<Permission> findByModuleName(String moduleName);
}