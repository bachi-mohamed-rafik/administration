package com.banking.admin_module.model.dto.Group.response;

import com.banking.admin_module.model.dto.Group.request.CreateGroupRequest;
import com.banking.admin_module.model.dto.Group.request.UpdateGroupRequest;
import com.banking.admin_module.model.dto.Group.response.GroupResponse;

public record GroupResponse(
        String code,

        String name,

        String url,

        String description

) {
}
