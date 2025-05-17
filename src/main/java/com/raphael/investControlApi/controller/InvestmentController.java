package com.raphael.investControlApi.controller;

import com.raphael.investControlApi.dto.InvestmentDTO;
import com.raphael.investControlApi.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController 
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService service;

    @GetMapping
    public List<InvestmentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<InvestmentDTO> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public InvestmentDTO create(@RequestBody InvestmentDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public InvestmentDTO update(@PathVariable Long id, @RequestBody InvestmentDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }




}
