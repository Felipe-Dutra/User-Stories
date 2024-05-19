package com.customer.aplication.controller;

import com.customer.aplication.domain.model.Cliente;
import com.customer.aplication.domain.model.Endereco;
import com.customer.aplication.domain.model.Estado;
import com.customer.aplication.domain.model.Municipio;
import com.customer.aplication.port.CepServicePort;
import com.customer.aplication.port.ClienteServicePort;
import com.customer.aplication.port.EstadoServicePort;
import com.customer.aplication.port.MunicipioServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServicePort clienteService;

    private final CepServicePort cepServicePort;

    private final EstadoServicePort estadoServicePort;

    private final MunicipioServicePort municipioServicePort;

    public ClienteController(ClienteServicePort clienteService, CepServicePort cepServicePort, EstadoServicePort estadoServicePort, MunicipioServicePort municipioServicePort) {
        this.clienteService = clienteService;
        this.cepServicePort = cepServicePort;
        this.estadoServicePort = estadoServicePort;
        this.municipioServicePort = municipioServicePort;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> consultarClientePorCPF(@PathVariable String cpf) {
        Cliente cliente = clienteService.consultarPorCpf(cpf);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> consultarEnderecoPorCEP(@PathVariable String cep) {
        Endereco endereco = cepServicePort.consultarPorCep(cep);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estados")
    public ResponseEntity<List<Estado>> listarEstados() {
        List<Estado> estados = estadoServicePort.buscarEstado();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/municipios/{idEstado}")
    public ResponseEntity<List<Municipio>> listarMunicipiosPorEstado(@PathVariable Integer idEstado) {
        List<Municipio> municipios = municipioServicePort.buscarPorMunicipios(idEstado);
        return ResponseEntity.ok(municipios);
    }

    @PutMapping("/{cpf}/endereco")
    public ResponseEntity<Cliente> alterarEnderecoCliente(@PathVariable String cpf, @RequestBody Endereco novoEndereco) {
        Cliente clienteAtualizado = clienteService.alterarEndereco(cpf, novoEndereco);
        if (clienteAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(clienteAtualizado);
    }

}
