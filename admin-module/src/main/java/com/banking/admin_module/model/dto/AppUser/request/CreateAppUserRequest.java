package com.banking.admin_module.model.dto.AppUser.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAppUserRequest(

        @Schema(description = "Nom de connexion de l'utilisateur (unique)", example = "jdoe@bna.dz")
        @NotBlank(message = "Le nom de connexion est obligatoire")
        @Size(max = 100, message = "Le nom de connexion ne doit pas dépasser 100 caractères")
        String loginName,

        @Schema(description = "Prénom de l'utilisateur", example = "Jean")
        @NotBlank(message = "Le prénom est obligatoire")
        @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
        String firstName,

        @Schema(description = "Nom de famille de l'utilisateur", example = "Dupont")
        @NotBlank(message = "Le nom de famille est obligatoire")
        @Size(max = 50, message = "Le nom de famille ne doit pas dépasser 50 caractères")
        String lastName,

        @Schema(description = "Prénom local de l'utilisateur", example = "جان")
        @Size(max = 50, message = "Le prénom local ne doit pas dépasser 50 caractères")
        String firstNameLocal,

        @Schema(description = "Nom de famille local de l'utilisateur", example = "دوبون")
        @Size(max = 50, message = "Le nom de famille local ne doit pas dépasser 50 caractères")
        String lastNameLocal,

        @Schema(description = "Nom d'utilisateur", example = "jdupont")
        @NotBlank(message = "Le nom d'utilisateur est obligatoire")
        @Size(max = 50, message = "Le nom d'utilisateur ne doit pas dépasser 50 caractères")
        String userName,

        @Schema(description = "Mot de passe initial de l'utilisateur", example = "SecurePass123!")
        @NotBlank(message = "Le mot de passe est obligatoire")
        @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
        String password,

        @Schema(description = "Identifiant de la banque", example = "1")
        @NotNull(message = "L'identifiant de la banque est obligatoire")
        Long bankId,

        @Schema(description = "Identifiant de la succursale", example = "1")
        @NotNull(message = "L'identifiant de la succursale est obligatoire")
        Long branchId,

        @Schema(description = "Indique si l'utilisateur peut vérifier les dérogations", example = "false")
        Boolean isOverrideChecker

) {
}