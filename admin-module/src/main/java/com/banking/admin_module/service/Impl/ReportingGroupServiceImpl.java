package com.banking.admin_module.service.Impl;

import com.banking.admin_module.model.dto.ReportingGroup.response.ReportingGroupResponse;
import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.repository.ReportingGroupRepository;
import com.banking.admin_module.service.ReportingGroupService;
import com.banking.admin_module.mapper.ReportingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportingGroupServiceImpl implements ReportingGroupService {

    private final ReportingGroupRepository reportingGroupRepository;
    private final ReportingMapper mapper;

    @Override
    public List<ReportingGroupResponse> getAllReportingGroups() {
        log.debug("Fetching all reporting groups");
        return reportingGroupRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReportingGroup getReportingGroupById(String id) {
        log.debug("Fetching reporting group with id: {}", id);
        return reportingGroupRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("ReportingGroup not found with id: {}", id);
                    return new RuntimeException("ReportingGroup not found with id: " + id);
                });
    }

    @Override
    public ReportingGroup createReportingGroup(ReportingGroup reportingGroup) {
        log.debug("Creating new reporting group with code: {}", reportingGroup.getCode());
        return reportingGroupRepository.save(reportingGroup);
    }

    @Override
    public ReportingGroup updateReportingGroup(String id, ReportingGroup details) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        reportingGroup.setCode(details.getCode());
        reportingGroup.setName(details.getName());
        reportingGroup.setDescription(details.getDescription());
        log.error("Updating reporting group with id: {}", id);
        return reportingGroupRepository.save(reportingGroup);
    }

    @Override
    public void deleteReportingGroup(String id) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        log.debug("Deleting reporting group with id: {}", id);
        reportingGroupRepository.delete(reportingGroup);
    }
}
