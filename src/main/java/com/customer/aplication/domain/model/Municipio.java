package com.customer.aplication.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Municipio {
    private Integer id;
    private String nome;
    private Microrregiao microrregiao;
    private RegiaoImediata regiaoImediata;
    private RegiaoIntermediaria regiaoIntermediaria;
}
