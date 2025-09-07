package com.example.BankLoan.controllers;

import com.example.BankLoan.entities.LoanProduct;
import com.example.BankLoan.service.LoanProductService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/products")
public class LoanProductController {

    private final LoanProductService loanProductService;

    public LoanProductController(LoanProductService loanProductService) {
        this.loanProductService = loanProductService;
    }

    @PostMapping
    public LoanProduct createProduct(@RequestBody LoanProduct product) {
        return loanProductService.saveLoanProduct(product);
    }

    @GetMapping
    public List<LoanProduct> getAllProducts() {
        return loanProductService.getAllProducts();
    }
}
