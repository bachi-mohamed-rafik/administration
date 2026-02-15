package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.BfsiGroup.request.CreateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.request.UpdateBfsiGroupRequest;
import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BfsiGroupMapper {

    @Mapping(target = "bankCount", expression = "java(bfsiGroup.getBanks() != null ? bfsiGroup.getBanks().size() : 0)")
    BfsiGroupResponse toResponse(BfsiGroup bfsiGroup);

    BfsiGroup toEntity(CreateBfsiGroupRequest request);

    void updateEntity(UpdateBfsiGroupRequest request, @MappingTarget BfsiGroup bfsiGroup);
}
