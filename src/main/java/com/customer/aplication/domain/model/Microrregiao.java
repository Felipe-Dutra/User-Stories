package com.customer.aplication.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Microrregiao {
    private Integer id;
    private String nome;
    private Mesorregiao mesorregiao;
}
