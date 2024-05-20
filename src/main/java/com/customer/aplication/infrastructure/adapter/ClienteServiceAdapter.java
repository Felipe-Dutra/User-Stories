package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.model.Endereco;
import com.customer.aplication.domain.repository.ClienteRepository;
import com.customer.aplication.port.ClienteServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceAdapter implements ClienteServicePort {

    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceAdapter.class);


    private final ClienteRepository clienteRepository;


    public ClienteServiceAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        logger.info("Consultando cliente com CPF: {}", cpf);
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            logger.debug("Cliente encontrado: {}", cliente);
        } else {
            logger.warn("Cliente com CPF {} não encontrado", cpf);
        }
        return cliente;
    }

    @Override
    public Cliente alterarEndereco(String cpf, Endereco novoEndereco) {
        logger.info("Alterando endereço para cliente com CPF: {}", cpf);

        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            Endereco enderecoExistente = cliente.getEndereco();
            if (enderecoExistente != null) {
                logger.debug("Endereço existente encontrado para o cliente: {}", enderecoExistente);
                enderecoExistente.setCep(novoEndereco.getCep());
                enderecoExistente.setLogradouro(novoEndereco.getLogradouro());
                enderecoExistente.setComplemento(novoEndereco.getComplemento());
                enderecoExistente.setBairro(novoEndereco.getBairro());
                enderecoExistente.setLocalidade(novoEndereco.getLocalidade());
                enderecoExistente.setUf(novoEndereco.getUf());
            } else {
                logger.debug("Nenhum endereço existente encontrado para o cliente, criando novo endereço.");
                cliente.setEndereco(novoEndereco);
            }
            cliente = clienteRepository.save(cliente);
        }
        return cliente;

    }

}
