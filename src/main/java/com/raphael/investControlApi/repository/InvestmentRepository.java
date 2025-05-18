package com.raphael.investControlApi.repository;

import com.raphael.investControlApi.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    Page<Investment> findByUserId(Long userId, Pageable pageable);

}
