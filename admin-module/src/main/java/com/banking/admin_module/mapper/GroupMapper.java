package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Group.request.CreateGroupRequest;
import com.banking.admin_module.model.dto.Group.request.UpdateGroupRequest;
import com.banking.admin_module.model.dto.Group.response.GroupResponse;

public interface GroupMapper

{

    CreateGroupRequest toEntity(CreateGroupRequest request);

    UpdateGroupRequest updateEntity(CreateGroupRequest request);

    GroupResponse toResponse(CreateGroupRequest request);

}
