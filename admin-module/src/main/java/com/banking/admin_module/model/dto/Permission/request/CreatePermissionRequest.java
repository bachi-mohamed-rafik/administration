package com.banking.admin_module.model.dto.Permission.request;

import com.banking.admin_module.model.entity.Group;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
public record CreatePermissionRequest(

        Group group,

        String orderId,

        String moduleName,

        Boolean isRead,

        Boolean isWrite,

        Boolean isAuthorize,

        Boolean isParentWithChildren

) {
}
