package com.attornatus.AttornatusAPI.pessoa.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
public class Endereco {

   private UUID idEndereco;
   private String logradouro;
   private String cep;
   private String numero;
   private String cidade;
   private Boolean enderecoPrincipal;
   @ManyToOne
   @JoinColumn(name = "pessoa_id")
   private Pessoa pessoa;

}
