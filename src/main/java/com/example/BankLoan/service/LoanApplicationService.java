package com.example.BankLoan.service;

import com.example.BankLoan.Repository.CustomerRepository;
import com.example.BankLoan.Repository.LoanApplicationRepository;
import com.example.BankLoan.Repository.LoanProductRepository;
import com.example.BankLoan.entities.Customer;
import com.example.BankLoan.entities.LoanApplication;
import com.example.BankLoan.entities.LoanProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final CustomerRepository customerRepository;
    private final LoanProductRepository loanProductRepository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository,
                                  CustomerRepository customerRepository,
                                  LoanProductRepository loanProductRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.customerRepository = customerRepository;
        this.loanProductRepository = loanProductRepository;
    }

    public LoanApplication applyForLoan(Long customerId, Long productId, double amount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        LoanProduct product = loanProductRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Loan product not found"));

        if (amount < product.getMinAmount() || amount > product.getMaxAmount()) {
            throw new RuntimeException("Loan amount must be between " + product.getMinAmount() + " and " + product.getMaxAmount());
        }

        LoanApplication application = LoanApplication.builder()
                .customer(customer)
                .loanProduct(product)
                .loanAmount(amount)
                .approvalStatus(LoanApplication.ApprovalStatus.PENDING)
                .build();

        return loanApplicationRepository.save(application);
    }

    public List<LoanApplication> getAllApplications() {
        return loanApplicationRepository.findAll();
    }

    public void updateApplicationStatus(Long applicationId, LoanApplication.ApprovalStatus status) {
        LoanApplication application = loanApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        application.setApprovalStatus(status);
        loanApplicationRepository.save(application);
    }
}
