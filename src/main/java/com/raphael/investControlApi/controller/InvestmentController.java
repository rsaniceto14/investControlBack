package com.raphael.investControlApi.controller;

import com.raphael.investControlApi.dto.InvestmentDTO;
import com.raphael.investControlApi.model.User;
import com.raphael.investControlApi.repository.UserRepository;

import com.raphael.investControlApi.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;
import java.security.Principal;

import java.util.Optional;


@RestController 
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService service;

    @Autowired
    private UserRepository userRepository;

    private Long getUserId(Principal principal) {
       String username = principal.getName();
       return userRepository.findByUsername(username)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
               .getId();
    }

    @GetMapping
    public ResponseEntity<Page<InvestmentDTO>> findAll(Pageable pageable, Principal principal) {
        return ResponseEntity.ok(service.findAll(getUserId(principal), pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestmentDTO> getById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(service.findById(id, getUserId(principal)));
    }

    @PostMapping
    public ResponseEntity<InvestmentDTO> create(@RequestBody InvestmentDTO dto, Principal principal) {
        return ResponseEntity.ok(service.save(dto, getUserId(principal)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvestmentDTO> update(@PathVariable Long id, @RequestBody InvestmentDTO dto, Principal principal) {
        return ResponseEntity.ok(service.update(id, dto, getUserId(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Principal principal) {
        service.delete(id, getUserId(principal));
        return ResponseEntity.noContent().build();
    }




}
