package com.customer.aplication.port;

import com.customer.aplication.domain.model.Municipio;

import java.util.List;

public interface MunicipioServicePort {
    List<Municipio> buscarPorMunicipios(Integer id);
}
