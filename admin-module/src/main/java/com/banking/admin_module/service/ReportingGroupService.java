package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.repository.ReportingGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportingGroupService {

    private final ReportingGroupRepository reportingGroupRepository;

    public List<ReportingGroup> getAllReportingGroups() {
        log.debug("Fetching all reporting groups");
        return reportingGroupRepository.findAll();
    }

    public ReportingGroup getReportingGroupById(String id) {
        log.debug("Fetching reporting group with id: {}", id);
        return reportingGroupRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("ReportingGroup not found with id: {}", id);
                    return new RuntimeException("ReportingGroup not found with id: " + id);
        });
    }

    public ReportingGroup createReportingGroup(ReportingGroup reportingGroup) {
        log.debug("Creating new reporting group with code: {}", reportingGroup.getCode());
        return reportingGroupRepository.save(reportingGroup);
    }

    public ReportingGroup updateReportingGroup(String id, ReportingGroup details) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        reportingGroup.setCode(details.getCode());
        reportingGroup.setName(details.getName());
        reportingGroup.setDescription(details.getDescription());
        log.error("Updating reporting group with id: {}", id);
        return reportingGroupRepository.save(reportingGroup);
    }

    public void deleteReportingGroup(String id) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        log.debug("Deleting reporting group with id: {}", id);
        reportingGroupRepository.delete(reportingGroup);
    }
}