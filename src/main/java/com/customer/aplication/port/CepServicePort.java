package com.customer.aplication.port;

import com.customer.aplication.domain.model.Endereco;

public interface CepServicePort {
    Endereco consultarPorCep(String cep);
}
