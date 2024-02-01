package com.attornatus.AttornatusAPI.pessoa.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
public class Endereco {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(columnDefinition = "uuid", name = "idEndereco", updatable = false, unique = true, nullable = false)
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
