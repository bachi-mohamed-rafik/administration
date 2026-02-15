package com.banking.admin_module.model.dto.BGMapping.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateBGMappingRequest(
        @Schema(description = "ID of the Bank", example = "1")
        Long bankId,
        @Schema(description = "ID of the Branch", example = "1")
        Long branchId,
        @Schema(description = "ID of the General Ledger", example = "1")
        Long generalLedgerId

) {
}
