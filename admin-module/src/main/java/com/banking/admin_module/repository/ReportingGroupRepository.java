package com.banking.admin_module.repository;

import com.banking.admin_module.entity.ReportingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportingGroupRepository extends JpaRepository<ReportingGroup, String> {
    Optional<ReportingGroup> findByCode(String code);
}