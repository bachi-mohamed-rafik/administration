package com.banking.admin_module.model.dto.ReportingGroup.request;

public record CreateReportingGroupRequest(
        String code,
        String name,
        String description
) {
}
