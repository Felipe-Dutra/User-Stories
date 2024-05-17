package com.customer.aplication.port;

import com.customer.aplication.domain.model.Cliente;


public interface ClienteServicePort {
    Cliente consultarPorCpf(String cpf);
}
