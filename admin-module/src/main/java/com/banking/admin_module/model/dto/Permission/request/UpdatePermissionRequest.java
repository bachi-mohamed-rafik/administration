package com.banking.admin_module.model.dto.Permission.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UpdatePermissionRequest(
        @Schema(description = "Updated order ID", example = "order123")
        @NotBlank(message = "Order ID is required")
        String orderId,

        @Schema(description = "Updated module name", example = "User Management")
        @NotBlank(message = "Module name is required")
        String moduleName,

        @Schema(description = "Updated read permission", example = "true")
        Boolean isRead,

        @Schema(description = "Updated write permission", example = "false")
        Boolean isWrite,

        @Schema(description = "Updated authorize permission", example = "true")
        Boolean isAuthorize,

        @Schema(description = "Updated parent-child relationship", example = "false")
        Boolean isParentWithChildren
) {
}
