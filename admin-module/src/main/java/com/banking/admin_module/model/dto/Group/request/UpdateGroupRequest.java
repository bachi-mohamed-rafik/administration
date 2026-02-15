package com.banking.admin_module.model.dto.Group.request;

public record UpdateGroupRequest(
        String code,

        String name,

        String url,

        String description

) {
}
