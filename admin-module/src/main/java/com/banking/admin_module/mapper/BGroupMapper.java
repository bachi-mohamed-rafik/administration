package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.BGroup.request.CreateBGoupRequest;
import com.banking.admin_module.model.dto.BGroup.response.BGroupResponse;
import com.banking.admin_module.model.entity.BGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BGroupMapper {

    BGroup toEntity(CreateBGoupRequest request);
    BGroupResponse toResponse(BGroup bGroup);
}
