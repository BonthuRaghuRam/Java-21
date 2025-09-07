package com.example.BankLoan.controllers;

import com.example.BankLoan.Repository.CustomerRepository;
import com.example.BankLoan.User.LoginRequest;
import com.example.BankLoan.User.RegisterRequest;
import com.example.BankLoan.User.User;
import com.example.BankLoan.User.UserRepository;
import com.example.BankLoan.entities.Customer;
import com.example.BankLoan.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // Example logic
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            return ResponseEntity.ok("Login successful! Role: ADMIN");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }




}

