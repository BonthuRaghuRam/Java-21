package com.example.BankLoan.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Table(name = "LoanApplication")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationId")
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "loanProductId", nullable = false)
    private LoanProduct loanProduct;

    private Double loanAmount;

    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    public enum ApprovalStatus {
        PENDING, APPROVED, REJECTED
    }
}