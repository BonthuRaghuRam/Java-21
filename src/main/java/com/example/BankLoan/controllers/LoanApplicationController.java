package com.example.BankLoan.controllers;

import com.example.BankLoan.entities.LoanApplication;
import com.example.BankLoan.service.LoanApplicationService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping
    public LoanApplication applyForLoan(@RequestParam Long customerId,
                                        @RequestParam Long productId,
                                        @RequestParam double amount) {
        return loanApplicationService.applyForLoan(customerId, productId, amount);
    }

    @GetMapping
    public List<LoanApplication> getAllApplications() {
        return loanApplicationService.getAllApplications();
    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam LoanApplication.ApprovalStatus status) {
        loanApplicationService.updateApplicationStatus(id, status);
    }
}

