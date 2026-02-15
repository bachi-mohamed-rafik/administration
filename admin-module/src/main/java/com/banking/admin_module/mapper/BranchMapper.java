package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.Branch.request.CreateBranchRequest;
import com.banking.admin_module.model.dto.Branch.response.BranchResponse;
import com.banking.admin_module.model.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchResponse toResponse(Branch branch);

    Branch toEntity(CreateBranchRequest request);

    void updateEntity(CreateBranchRequest request,@MappingTarget Branch branch);
}
