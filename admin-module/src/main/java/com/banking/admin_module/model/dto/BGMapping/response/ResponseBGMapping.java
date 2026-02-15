package com.banking.admin_module.model.dto.BGMapping.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ResponseBGMapping", description = "Response DTO for BG Mapping")
public record ResponseBGMapping(
        @Schema(description = "ID of the BG Mapping", example = "1")
        Long id,
        @Schema(description = "ID of the Bank", example = "1")
        Long bankId,
        @Schema(description = "ID of the Branch", example = "1")
        Long branchId,
        @Schema(description = "ID of the General Ledger", example = "1")
        Long generalLedgerId

) {
}
