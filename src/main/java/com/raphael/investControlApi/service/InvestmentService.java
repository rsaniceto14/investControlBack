package com.raphael.investControlApi.service;

import com.raphael.investControlApi.dto.InvestmentDTO;
import com.raphael.investControlApi.model.Investment;
import com.raphael.investControlApi.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvestmentService {


    @Autowired
    private InvestmentRepository investmentRepository;

   public List<InvestmentDTO> findAll(){
    return investmentRepository.findAll()
            .stream()
            .map(InvestmentDTO::new)
            .collect(Collectors.toList());  
   }

   public Optional<InvestmentDTO> findById(Long id){
    return investmentRepository.findById(id)
            .map(InvestmentDTO::new);
   }
   public InvestmentDTO save(InvestmentDTO dto){
    Investment investment = new Investment(dto);
    Investment saved = investmentRepository.save(investment);
    return new InvestmentDTO(saved);

   }

   public void delete(Long id){
    investmentRepository.deleteById(id);
   }

   public InvestmentDTO update(Long id, InvestmentDTO dto){
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
