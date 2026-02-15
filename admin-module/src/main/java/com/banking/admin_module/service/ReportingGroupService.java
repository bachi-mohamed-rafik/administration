package com.banking.admin_module.service;


import com.banking.admin_module.model.dto.ReportingGroup.response.ReportingGroupResponse;
import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.repository.ReportingGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReportingGroupService {

    public List<ReportingGroupResponse> getAllReportingGroups();

    public ReportingGroup getReportingGroupById(String id);

    public ReportingGroup createReportingGroup(ReportingGroup reportingGroup);

    public ReportingGroup updateReportingGroup(String id, ReportingGroup details);

    public void deleteReportingGroup(String id);
}