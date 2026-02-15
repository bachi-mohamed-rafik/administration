package com.banking.admin_module.model.dto.BGroup.request;

import jakarta.persistence.Column;

public record CreateBGoupRequest(

        String code,
        String name,
        String description
) {
}
