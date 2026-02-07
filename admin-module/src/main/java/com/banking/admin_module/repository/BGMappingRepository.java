package com.banking.admin_module.repository;

import com.banking.admin_module.entity.BGMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BGMappingRepository extends JpaRepository<BGMapping, String> {
    List<BGMapping> findByUserId(String userId);
    List<BGMapping> findByBankId(String bankId);
    List<BGMapping> findByBusinessGroupId(String businessGroupId);
}