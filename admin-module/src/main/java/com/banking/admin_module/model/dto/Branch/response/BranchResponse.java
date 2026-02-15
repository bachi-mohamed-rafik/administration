package com.banking.admin_module.model.dto.Branch.response;

import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.model.enums.Status;
import com.banking.admin_module.model.enums.isMainBranch;

public record BranchResponse(
        Bank bank,

        String branchName,

        String branchCode,

        String branchNameLocal,

        String adress,

        Status status,

        isMainBranch isMainBranch

) {
}
