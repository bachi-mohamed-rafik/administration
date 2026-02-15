package com.banking.admin_module.model.dto.Branch.request;

import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.model.enums.Status;
import com.banking.admin_module.model.enums.isMainBranch;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateBranchRequest(
        @Schema(description = "Identifiant de la banque", example = "1")
        @NotNull(message = "L'identifiant de la banque est obligatoire")
        Long bankId,  // Changed from Bank to Long

        @Schema(description = "Nom de la succursale", example = "Agence Alger Centre")
        @NotBlank(message = "Le nom de la succursale est obligatoire")
        String branchName,

        @Schema(description = "Code de la succursale", example = "ALG001")
        @NotBlank(message = "Le code de la succursale est obligatoire")
        String branchCode,

        @Schema(description = "Nom local de la succursale", example = "فرع الجزائر الوسطى")
        String branchNameLocal,

        @Schema(description = "Adresse de la succursale", example = "123 Rue Didouche Mourad, Alger")
        @NotBlank(message = "L'adresse est obligatoire")
        String address,  // Fixed typo: was "adress"

        @Schema(description = "Statut de la succursale", example = "ACTIVE")
        @NotNull(message = "Le statut est obligatoire")
        Status status,

        @Schema(description = "Est-ce la succursale principale?", example = "NO")
        @NotNull(message = "isMainBranch est obligatoire")
        isMainBranch isMainBranch

) {
}
