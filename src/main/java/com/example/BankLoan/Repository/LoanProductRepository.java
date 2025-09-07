package com.example.BankLoan.Repository;

import com.example.BankLoan.entities.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct, Long> {
}
