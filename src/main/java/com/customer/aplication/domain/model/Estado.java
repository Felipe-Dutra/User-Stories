package com.customer.aplication.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado {
  private  Integer id;
  private  String sigla;
  private  String nome;
  private  Regiao regiao;

}
