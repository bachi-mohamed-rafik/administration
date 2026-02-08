package com.banking.admin_module.repository;

import com.banking.admin_module.model.entity.BGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BGroupRepository extends JpaRepository<BGroup, String> {
    Optional<BGroup> findByCode(String code);
    Optional<BGroup> findByName(String name);
}