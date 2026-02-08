package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.Permission;
import com.banking.admin_module.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(String id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id: " + id));
    }

    public List<Permission> getPermissionsByGroupId(String groupId) {
        return permissionRepository.findByGroupId(groupId);
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission updatePermission(String id, Permission details) {
        Permission permission = getPermissionById(id);
        permission.setGroup(details.getGroup());
        permission.setOrderId(details.getOrderId());
        permission.setModuleName(details.getModuleName());
        permission.setIsRead(details.getIsRead());
        permission.setIsWrite(details.getIsWrite());
        permission.setIsAuthorize(details.getIsAuthorize());
        permission.setIsParentWithChildren(details.getIsParentWithChildren());
        return permissionRepository.save(permission);
    }

    public void deletePermission(String id) {
        Permission permission = getPermissionById(id);
        permissionRepository.delete(permission);
    }
}