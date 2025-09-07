package com.example.BankLoan.service;
import com.example.BankLoan.Repository.LoanApplicationRepository;
import com.example.BankLoan.Repository.RepaymentRepository;
import com.example.BankLoan.entities.LoanApplication;
import com.example.BankLoan.entities.Repayment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RepaymentService {

    private final RepaymentRepository repaymentRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    public RepaymentService(RepaymentRepository repaymentRepository,
                            LoanApplicationRepository loanApplicationRepository) {
        this.repaymentRepository = repaymentRepository;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public Repayment createRepayment(Long applicationId, LocalDate dueDate, double amountDue) {
        LoanApplication application = loanApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Repayment repayment = Repayment.builder()
                .loanApplication(application)
                .dueDate(dueDate)
                .amountDue(amountDue)
                .paymentStatus(Repayment.PaymentStatus.PENDING)
                .build();

        return repaymentRepository.save(repayment);
    }

    public List<Repayment> getRepaymentsByApplication(Long applicationId) {
        return repaymentRepository.findByLoanApplication_ApplicationId(applicationId);
    }

    public void markRepaymentAsPaid(Long repaymentId, LocalDate paymentDate) {
        Repayment repayment = repaymentRepository.findById(repaymentId)
                .orElseThrow(() -> new RuntimeException("Repayment not found"));
        repayment.setPaymentDate(paymentDate);
        repayment.setPaymentStatus(Repayment.PaymentStatus.COMPLETED);
        repaymentRepository.save(repayment);
    }
}

