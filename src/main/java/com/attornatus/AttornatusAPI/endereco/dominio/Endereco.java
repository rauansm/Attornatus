package com.attornatus.AttornatusAPI.endereco.dominio;

import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoRequest;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
   private Boolean enderecoPrincipal = false;
   @ManyToOne
   @JoinColumn(name = "pessoa_id")
   private Pessoa pessoa;

   public Endereco (Pessoa pessoa,EnderecoRequest enderecoRequest){
      this.idEndereco = UUID.randomUUID();
      this.logradouro = enderecoRequest.getLogradouro();
      this.cep = enderecoRequest.getCep();
      this.numero = enderecoRequest.getNumero();
      this.cidade = enderecoRequest.getCidade();
      this.pessoa = pessoa;
   }
}
