package com.banking.admin_module.mapper;

import com.banking.admin_module.model.dto.BGroup.request.CreateBGoupRequest;
import com.banking.admin_module.model.dto.ReportingGroup.response.ReportingGroupResponse;
import com.banking.admin_module.model.entity.ReportingGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportingMapper {
    ReportingGroup toEntity(CreateBGoupRequest request);

    ReportingGroup updateEntity(ReportingGroup reportingGroup);

    ReportingGroupResponse toResponse(ReportingGroup reportingGroup);
}
