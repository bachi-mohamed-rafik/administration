package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.ReportingGroup;
import com.banking.admin_module.repository.ReportingGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportingGroupService {

    private final ReportingGroupRepository reportingGroupRepository;

    public List<ReportingGroup> getAllReportingGroups() {
        return reportingGroupRepository.findAll();
    }

    public ReportingGroup getReportingGroupById(String id) {
        return reportingGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ReportingGroup not found with id: " + id));
    }

    public ReportingGroup createReportingGroup(ReportingGroup reportingGroup) {
        return reportingGroupRepository.save(reportingGroup);
    }

    public ReportingGroup updateReportingGroup(String id, ReportingGroup details) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        reportingGroup.setCode(details.getCode());
        reportingGroup.setName(details.getName());
        reportingGroup.setDescription(details.getDescription());
        return reportingGroupRepository.save(reportingGroup);
    }

    public void deleteReportingGroup(String id) {
        ReportingGroup reportingGroup = getReportingGroupById(id);
        reportingGroupRepository.delete(reportingGroup);
    }
}