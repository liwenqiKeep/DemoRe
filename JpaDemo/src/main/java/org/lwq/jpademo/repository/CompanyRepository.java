package org.lwq.jpademo.repository;

import org.lwq.jpademo.entity.AccountSecure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<AccountSecure, Integer> {
}
