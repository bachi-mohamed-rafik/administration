package com.banking.admin_module.service.Impl;

import com.banking.admin_module.model.entity.Permission;
import com.banking.admin_module.repository.PermissionRepository;
import com.banking.admin_module.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        log.debug("Fetching all permissions");
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(String id) {
        log.debug("Fetching permission with id: {}", id);
        return permissionRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Permission not found with id: {}", id);
                    return new RuntimeException("Permission not found with id: " + id);
                });
    }

    public List<Permission> getPermissionsByGroupId(String groupId) {
        log.debug("Fetching permissions for group id: {}", groupId);
        return permissionRepository.findByGroupId(groupId);
    }

    public Permission createPermission(Permission permission) {
        log.debug("Creating new permission for module: {}", permission.getModuleName());
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
        log.debug("Updating permission with id: {}", id);
        return permissionRepository.save(permission);
    }

    public void deletePermission(String id) {
        Permission permission = getPermissionById(id);
        log.debug("Deleting permission with id: {}", id);
        permissionRepository.delete(permission);
    }
}
