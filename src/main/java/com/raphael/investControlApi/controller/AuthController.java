package com.raphael.investControlApi.controller;

import com.raphael.investControlApi.model.User;
import com.raphael.investControlApi.dto.AuthRequest;
import com.raphael.investControlApi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.raphael.investControlApi.security.JwtUtils;
import com.raphael.investControlApi.dto.AuthResponse;


import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        try {
            userService.register(request.getUsername(), request.getPassword());
            return ResponseEntity.ok("Usuario registrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao registrar usuario");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Optional<User> user = userService.login(request.getUsername(), request.getPassword());

        if(user.isPresent()){
            String token = jwtUtils.generateJwtToken(user.get());
            return ResponseEntity.ok(new AuthResponse(token));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario ou senha invalidos");
        }
    }



}
