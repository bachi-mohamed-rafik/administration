package com.banking.admin_module.repository;

import com.banking.admin_module.model.dto.BfsiGroup.response.BfsiGroupResponse;
import com.banking.admin_module.model.entity.BfsiGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BfsiRepository  extends JpaRepository<BfsiGroup,Long> {

    @Query("SELECT g FROM BfsiGroup g LEFT JOIN FETCH g.banks")
    List<BfsiGroup> findAllWithBanks();

    List<BfsiGroup> id(Long id);
}
