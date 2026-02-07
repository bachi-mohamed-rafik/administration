package com.banking.admin_module.repository;

import com.banking.admin_module.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
    Bank findBankById(Long id);
}
