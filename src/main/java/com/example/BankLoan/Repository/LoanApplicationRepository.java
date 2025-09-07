package com.example.BankLoan.Repository;

import com.example.BankLoan.entities.Customer;
import com.example.BankLoan.entities.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
    List<LoanApplication> findByCustomer(Customer customer);
}
