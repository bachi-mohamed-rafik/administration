package com.banking.admin_module.model.dto.AppUser.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

public record AppUserResponse(

        @Schema(description = "Identifiant de l'utilisateur")
        String id,

        @Schema(description = "Nom de connexion")
        String loginName,

        @Schema(description = "Prénom")
        String firstName,

        @Schema(description = "Nom de famille")
        String lastName,

        @Schema(description = "Nom d'utilisateur")
        String userName,

        @Schema(description = "Identifiant de la banque")
        Long bankId,

        @Schema(description = "Nom de la banque")
        String bankName,

        @Schema(description = "Identifiant de la succursale")
        Long branchId,

        @Schema(description = "Nom de la succursale")
        String branchName,

        @Schema(description = "L'utilisateur est-il bloqué?")
        Boolean isBlocked,

        @Schema(description = "L'utilisateur est-il actif?")
        Boolean isActive,

        @Schema(description = "Peut vérifier les dérogations")
        Boolean isOverrideChecker,

        @Schema(description = "Date de création")
        LocalDateTime createdTime

) {
}