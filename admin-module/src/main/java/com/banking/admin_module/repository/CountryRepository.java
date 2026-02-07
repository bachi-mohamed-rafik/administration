package com.banking.admin_module.repository;

import com.banking.admin_module.entity.Country;
import com.banking.admin_module.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
