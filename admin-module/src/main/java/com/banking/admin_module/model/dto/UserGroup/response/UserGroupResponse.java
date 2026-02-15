package com.banking.admin_module.model.dto.UserGroup.response;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.model.entity.Group;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public record UserGroupResponse(
        AppUser user,
        Group group,
        Boolean persisted
) {
}
