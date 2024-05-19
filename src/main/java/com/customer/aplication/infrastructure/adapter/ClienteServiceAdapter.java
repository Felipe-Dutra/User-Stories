package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.model.Endereco;
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

    @Override
    public Cliente alterarEndereco(String cpf, Endereco novoEndereco) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            Endereco enderecoExistente = cliente.getEndereco();
            if (enderecoExistente != null) {
                enderecoExistente.setCep(novoEndereco.getCep());
                enderecoExistente.setLogradouro(novoEndereco.getLogradouro());
                enderecoExistente.setComplemento(novoEndereco.getComplemento());
                enderecoExistente.setBairro(novoEndereco.getBairro());
                enderecoExistente.setLocalidade(novoEndereco.getLocalidade());
                enderecoExistente.setUf(novoEndereco.getUf());
            } else {
                cliente.setEndereco(novoEndereco);
            }
            cliente = clienteRepository.save(cliente);
        }
        return cliente;

    }

}
