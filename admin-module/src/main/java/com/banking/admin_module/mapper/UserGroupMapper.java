package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.UserGroup.request.CreateUserGroupRequest;
import com.banking.admin_module.model.dto.UserGroup.response.UserGroupResponse;
import com.banking.admin_module.model.entity.UserGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGroupMapper {

    UserGroup toEntity(CreateUserGroupRequest request);

    UserGroupResponse updateEntity(UserGroup userGroup);

    UserGroupResponse toResponse(UserGroup userGroup);
}
