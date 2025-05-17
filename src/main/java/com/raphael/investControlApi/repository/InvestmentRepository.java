package com.raphael.investControlApi.repository;

import com.raphael.investControlApi.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
