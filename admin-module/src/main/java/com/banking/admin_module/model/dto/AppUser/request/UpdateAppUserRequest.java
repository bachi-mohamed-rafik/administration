package com.banking.admin_module.model.dto.AppUser.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public record UpdateAppUserRequest(

        @Schema(description = "Prénom de l'utilisateur", example = "Jean")
        @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
        String firstName,

        @Schema(description = "Nom de famille de l'utilisateur", example = "Dupont")
        @Size(max = 50, message = "Le nom de famille ne doit pas dépasser 50 caractères")
        String lastName,

        @Schema(description = "Prénom local", example = "جان")
        String firstNameLocal,

        @Schema(description = "Nom de famille local", example = "دوبون")
        String lastNameLocal,

        @Schema(description = "Identifiant de la banque")
        Long bankId,

        @Schema(description = "Identifiant de la succursale")
        Long branchId,

        @Schema(description = "Peut vérifier les dérogations")
        Boolean isOverrideChecker,

        @Schema(description = "Statut bloqué", example = "false")
        Boolean isBlocked,

        @Schema(description = "Statut actif", example = "true")
        Boolean isActive

) {
}