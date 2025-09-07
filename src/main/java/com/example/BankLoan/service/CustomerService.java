package com.example.BankLoan.service;
import com.example.BankLoan.Repository.CustomerRepository;
import com.example.BankLoan.entities.Customer;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void updateKycStatus(Long id, Customer.KycStatus status) {
        Customer customer = getCustomerById(id);
        customer.setKycStatus(status);
        customerRepository.save(customer);
    }

    public Customer login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!customer.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return customer;
    }
}


