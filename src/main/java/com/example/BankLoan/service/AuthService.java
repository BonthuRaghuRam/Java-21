package com.example.BankLoan.service;

import com.example.BankLoan.User.LoginRequest;
import com.example.BankLoan.User.User;
import com.example.BankLoan.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return "Login successful! Role: " + user.getRole();
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }
}
