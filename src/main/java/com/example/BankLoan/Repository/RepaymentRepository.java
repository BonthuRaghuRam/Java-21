package com.example.BankLoan.Repository;



import com.example.BankLoan.entities.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepaymentRepository extends JpaRepository<Repayment, Long> {

    // Custom finder: get all repayments by loan application id
    List<Repayment> findByLoanApplication_ApplicationId(Long applicationId);
}
