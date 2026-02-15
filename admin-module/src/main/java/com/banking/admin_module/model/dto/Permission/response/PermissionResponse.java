package com.banking.admin_module.model.dto.Permission.response;

public record PermissionResponse(
        Long id,
        String orderId,
        String moduleName,
        Boolean isRead,
        Boolean isWrite,
        Boolean isAuthorize,
        Boolean isParentWithChildren
) {
}
