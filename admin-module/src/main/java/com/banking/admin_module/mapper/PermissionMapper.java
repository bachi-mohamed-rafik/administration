package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Permission.request.CreatePermissionRequest;
import com.banking.admin_module.model.dto.Permission.request.UpdatePermissionRequest;
import com.banking.admin_module.model.dto.Permission.response.PermissionResponse;
import com.banking.admin_module.model.entity.Permission;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toEntity(CreatePermissionRequest request);

    PermissionResponse updateEntity(UpdatePermissionRequest request);

    PermissionResponse toResponse(Permission permission);
}
