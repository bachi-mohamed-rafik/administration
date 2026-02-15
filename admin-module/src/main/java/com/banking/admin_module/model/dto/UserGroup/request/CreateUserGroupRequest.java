package com.banking.admin_module.model.dto.UserGroup.request;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.model.entity.Group;

public record CreateUserGroupRequest(
        AppUser user,
        Group group,
        Boolean persisted

) {
}
