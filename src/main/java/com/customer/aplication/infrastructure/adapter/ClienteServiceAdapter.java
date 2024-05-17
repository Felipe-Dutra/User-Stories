package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.repository.ClienteRepository;
import com.customer.aplication.port.ClienteServicePort;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceAdapter implements ClienteServicePort {

    private final ClienteRepository clienteRepository;


    public ClienteServiceAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}
