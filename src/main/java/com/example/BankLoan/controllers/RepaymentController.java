package com.example.BankLoan.controllers;

import com.example.BankLoan.entities.Repayment;
import com.example.BankLoan.service.RepaymentService;
import org.springframework.web.bind.annotation.*;

        import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    private final RepaymentService repaymentService;

    public RepaymentController(RepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }

    @PostMapping
    public Repayment createRepayment(@RequestParam Long applicationId,
                                     @RequestParam String dueDate,
                                     @RequestParam double amountDue) {
        return repaymentService.createRepayment(applicationId, LocalDate.parse(dueDate), amountDue);
    }

    @GetMapping("/{applicationId}")
    public List<Repayment> getRepayments(@PathVariable Long applicationId) {
        return repaymentService.getRepaymentsByApplication(applicationId);
    }

    @PatchMapping("/{id}/pay")
    public void markAsPaid(@PathVariable Long id, @RequestParam String paymentDate) {
        repaymentService.markRepaymentAsPaid(id, LocalDate.parse(paymentDate));
    }
}
