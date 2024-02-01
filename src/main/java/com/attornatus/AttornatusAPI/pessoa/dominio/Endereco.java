package com.attornatus.AttornatusAPI.pessoa.dominio;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Endereco {

   private String logradouro;
   private String cep;
   private String numero;
   private String cidade;

}
