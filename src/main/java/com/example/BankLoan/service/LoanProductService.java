package com.example.BankLoan.service;


import com.example.BankLoan.Repository.LoanProductRepository;
import com.example.BankLoan.entities.LoanProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanProductService {

    private final LoanProductRepository loanProductRepository;

    public LoanProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }

    public LoanProduct saveLoanProduct(LoanProduct loanProduct) {
        return loanProductRepository.save(loanProduct);
    }

    public List<LoanProduct> getAllProducts() {
        return loanProductRepository.findAll();
    }
}

