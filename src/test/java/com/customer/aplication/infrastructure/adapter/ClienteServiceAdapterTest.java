package com.customer.aplication.infrastructure.adapter;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceAdapterTest {

    @InjectMocks
    private ClienteServiceAdapter clienteServiceAdapter;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultarPorCpf() {
        // Given
        String cpf = "12345678900";
        Cliente clienteEsperado = new Cliente();

        // Simula o comportamento do clienteRepository.findByCpf()
        when(clienteRepository.findByCpf(cpf)).thenReturn(clienteEsperado);

        // When
        Cliente clienteRetornado = clienteServiceAdapter.consultarPorCpf(cpf);

        // Then
        assertEquals(clienteEsperado, clienteRetornado);
        // Verifica se o método clienteRepository.findByCpf() foi chamado com o CPF correto
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }

}