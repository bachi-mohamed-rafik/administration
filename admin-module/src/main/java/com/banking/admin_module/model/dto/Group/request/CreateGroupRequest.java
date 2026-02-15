package com.banking.admin_module.model.dto.Group.request;

import com.banking.admin_module.model.entity.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public record CreateGroupRequest(

        String code,

        String name,

        String url,

        String description

) {
}
