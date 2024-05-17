package com.customer.aplication.domain.repository;

import com.customer.aplication.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,String> {
        Cliente findByCpf(String cpf);
    }

