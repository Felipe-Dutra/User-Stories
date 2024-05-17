package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Endereco;
import com.customer.aplication.port.CepServicePort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceAdapter implements CepServicePort {
    private final RestTemplate restTemplate;

    public CepServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Endereco consultarPorCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(url, Endereco.class);
    }
}
