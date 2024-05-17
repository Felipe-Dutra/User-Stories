package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CepServiceAdapterTest {

    private CepServiceAdapter cepServiceAdapter;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cepServiceAdapter = new CepServiceAdapter(restTemplate);
    }

    @Test
    public void testConsultarPorCep() {
        // Given
        String cep = "12345678";
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        Endereco enderecoEsperado = new Endereco();

        // Simula o comportamento do restTemplate.getForObject()
        when(restTemplate.getForObject(url, Endereco.class)).thenReturn(enderecoEsperado);

        // When
        Endereco enderecoRetornado = cepServiceAdapter.consultarPorCep(cep);

        // Then
        assertEquals(enderecoEsperado, enderecoRetornado);
        // Verifica se o método restTemplate.getForObject() foi chamado com a URL correta
        verify(restTemplate, times(1)).getForObject(url, Endereco.class);
    }

}