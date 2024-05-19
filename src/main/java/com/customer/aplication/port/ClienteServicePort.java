package com.customer.aplication.port;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.model.Endereco;


public interface ClienteServicePort {
    Cliente consultarPorCpf(String cpf);
    Cliente alterarEndereco(String cpf, Endereco novoEnderco);
}
