package com.banking.admin_module.repository;

import com.banking.admin_module.entity.BfsiGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BfsiRepository  extends JpaRepository<BfsiGroup,Long> {
    List<BfsiGroup> id(Long id);
}
