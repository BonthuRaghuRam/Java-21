package com.example.BankLoan.Repository;

import com.example.BankLoan.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Method to find a customer by email
    Optional<Customer> findByEmail(String email);
}
