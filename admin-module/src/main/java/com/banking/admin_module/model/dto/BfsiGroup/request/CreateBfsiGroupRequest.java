package com.banking.admin_module.model.dto.BfsiGroup.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(
        name = "CreateBfsiGroupRequest",
        description = "Request DTO for creating a new BFSI Group. This DTO contains the necessary information to create a BFSI Group in the system.")
public record CreateBfsiGroupRequest(
        @Schema(description = "The name of the BFSI Group", example = "Retail Banking")
        @NotNull(message = "BFSI Group name cannot be null")
        String name,

        @Schema(description = "A brief description of the BFSI Group", example = "Group responsible for retail banking operations")
        String description
) {
}
