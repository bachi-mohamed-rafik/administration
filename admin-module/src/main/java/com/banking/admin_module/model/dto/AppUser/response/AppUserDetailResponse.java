package com.banking.admin_module.model.dto.AppUser.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

public record AppUserDetailResponse(

        @Schema(description = "Identifiant de l'utilisateur")
        String id,

        @Schema(description = "Nom de connexion")
        String loginName,

        @Schema(description = "Prénom")
        String firstName,

        @Schema(description = "Nom de famille")
        String lastName,

        @Schema(description = "Prénom local")
        String firstNameLocal,

        @Schema(description = "Nom de famille local")
        String lastNameLocal,

        @Schema(description = "Nom d'utilisateur")
        String userName,

        @Schema(description = "Identifiant de la banque")
        Long bankId,

        @Schema(description = "Nom de la banque")
        String bankName,

        @Schema(description = "Code de la banque")
        String bankCode,

        @Schema(description = "Identifiant de la succursale")
        Long branchId,

        @Schema(description = "Nom de la succursale")
        String branchName,

        @Schema(description = "Code de la succursale")
        String branchCode,

        @Schema(description = "L'utilisateur est-il bloqué?")
        Boolean isBlocked,

        @Schema(description = "L'utilisateur est-il actif?")
        Boolean isActive,

        @Schema(description = "Est-ce la première connexion?")
        Boolean isFirstTimeLogin,

        @Schema(description = "L'utilisateur est connecté?")
        Integer isLoggedIn,

        @Schema(description = "Peut vérifier les dérogations")
        Boolean isOverrideChecker,

        @Schema(description = "Nombre de tentatives de connexion échouées")
        Integer countAttempts,

        @Schema(description = "Nombre de groupes d'utilisateurs")
        Integer userGroupCount,

        @Schema(description = "Nombre de mappings de groupes métier")
        Integer bgMappingCount,

        @Schema(description = "Date de création")
        LocalDateTime createdTime,

        @Schema(description = "Date de modification")
        LocalDateTime modifiedTime,

        @Schema(description = "Dernière connexion")
        LocalDateTime lastLoginTime

) {
}