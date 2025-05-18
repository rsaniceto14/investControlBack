package com.raphael.investControlApi.service;

import com.raphael.investControlApi.dto.InvestmentDTO;
import com.raphael.investControlApi.model.Investment;
import com.raphael.investControlApi.repository.InvestmentRepository;
import com.raphael.investControlApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raphael.investControlApi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;


@Service
public class InvestmentService {


    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private UserRepository userRepository;

   public Page<InvestmentDTO> findAll(Long userId, Pageable pageable){
        return investmentRepository.findByUserId(userId, pageable)
                .map(InvestmentDTO::new);
   }

   public InvestmentDTO findById(Long id, Long userId) {
        Investment investment = investmentRepository.findById(id)
                .filter(inv -> inv.getUser().getId().equals(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new InvestmentDTO(investment);
    }

   public InvestmentDTO save(InvestmentDTO dto, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Investment investment = new Investment(dto);
    investment.setUser(user);
    Investment saved = investmentRepository.save(investment);
    return new InvestmentDTO(saved);

   }

   public void delete(Long id, Long userId){
        Investment investment = investmentRepository.findById(id)
                .filter(inv -> inv.getUser().getId().equals(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    investmentRepository.deleteById(id);
   }

   public InvestmentDTO update(Long id, InvestmentDTO dto, Long userId) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Optional<Investment> optional = investmentRepository.findById(id);
    if (optional.isEmpty()) throw new RuntimeException("Investmento não encontrado");

    Investment investment = optional.get();
    investment.setName(dto.getName());
    investment.setType(dto.getType());
    investment.setValueInvested(dto.getValueInvested());
    investment.setInvestmentDate(dto.getInvestmentDate());

    Investment updated = investmentRepository.save(investment);
    return new InvestmentDTO(updated);
   }

}
