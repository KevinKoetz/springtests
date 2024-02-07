package com.example.demo.persistence.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.persistence.models.Customer;

public interface CustomerRespository extends JpaRepository<Customer, UUID>{
    
}
