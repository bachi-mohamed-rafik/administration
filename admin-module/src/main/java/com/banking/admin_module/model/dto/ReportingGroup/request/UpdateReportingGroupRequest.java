package com.banking.admin_module.model.dto.ReportingGroup.request;

public record UpdateReportingGroupRequest(
        String code,
        String name,
        String description
) {
}
