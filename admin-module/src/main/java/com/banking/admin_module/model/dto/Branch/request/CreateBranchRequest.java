package com.banking.admin_module.model.dto.Branch.request;

import com.banking.admin_module.model.entity.Bank;
import com.banking.admin_module.model.enums.Status;
import com.banking.admin_module.model.enums.isMainBranch;
import jakarta.persistence.*;

public record CreateBranchRequest(

        Bank bank,

        String branchName,

        String branchCode,

        String branchNameLocal,

        String adress,

        Status status,

        isMainBranch isMainBranch
) {
}
