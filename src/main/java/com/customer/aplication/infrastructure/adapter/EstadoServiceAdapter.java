package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Endereco;
import com.customer.aplication.domain.model.Estado;
import com.customer.aplication.port.EstadoServicePort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceAdapter implements EstadoServicePort {

    private final RestTemplate restTemplate;

    public EstadoServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Estado> buscarEstado() {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
        Estado[] estados = restTemplate.getForObject(url, Estado[].class);

        // Ordena os estados: São Paulo e Rio de Janeiro primeiro, os demais em ordem alfabética
        return Arrays.stream(estados)
                .sorted(Comparator.comparing((Estado estado) -> {
                    if ("São Paulo".equals(estado.getNome())) {
                        return 0;
                    } else if ("Rio de Janeiro".equals(estado.getNome())) {
                        return 1;
                    } else {
                        return 2;
                    }
                }).thenComparing(Estado::getNome))
                .collect(Collectors.toList());
    }
}
