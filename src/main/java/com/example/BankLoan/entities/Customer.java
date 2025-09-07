package com.example.BankLoan.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    private String name;

    private String email;

    private String phone;

    private String address;
    private String password;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;



    public enum KycStatus {
        PENDING, VERIFIED
    }
}
