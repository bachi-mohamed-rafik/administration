package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Permission;
import com.banking.admin_module.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionService {

    public List<Permission> getAllPermissions();

    public Permission getPermissionById(String id);

    public List<Permission> getPermissionsByGroupId(String groupId);

    public Permission createPermission(Permission permission);

    public Permission updatePermission(String id, Permission details);

    public void deletePermission(String id);
}