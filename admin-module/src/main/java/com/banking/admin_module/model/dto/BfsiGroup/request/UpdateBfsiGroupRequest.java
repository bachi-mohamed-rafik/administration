package com.banking.admin_module.model.dto.BfsiGroup.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateBfsiGroupRequest(

        @Schema(description = "Nom du groupe BFSI", example = "Groupe Bancaire A")
        @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
        String name,

        @Schema(description = "Description du groupe BFSI")
        String description

) {}