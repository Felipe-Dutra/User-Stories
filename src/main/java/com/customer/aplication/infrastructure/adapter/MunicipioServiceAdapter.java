package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Municipio;
import com.customer.aplication.port.MunicipioServicePort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MunicipioServiceAdapter implements MunicipioServicePort {

    private final RestTemplate restTemplate;

    public MunicipioServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Municipio> buscarPorMunicipios(Integer id) {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/{id}/municipios";
        Municipio[] municipios = restTemplate.getForObject(url, Municipio[].class, id);
        return Arrays.asList(municipios);
    }
}
