package com.attornatus.AttornatusAPI;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataHelper {

    private static final UUID pessoaId = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");

    public static Pessoa createPessoa() {
        return Pessoa.builder().nome("Lucas").dataNascimento(LocalDate.of(2000, 11, 20)).enderecos(new ArrayList<>()).idPessoa(pessoaId).build();
    }

    public static Endereco createEndereco() {
        return Endereco.builder().numero("11").idEndereco(UUID.fromString("06fb5521-9d5a-461a-82fb-e67e3bedc6eb"))
                .pessoa(createPessoa()).cep("20983-111").cidade("Paraiba").logradouro("Rua").enderecoPrincipal(false).build();
    }

    public static PessoaResquest getPessoaRequest() {
        PessoaResquest pessoaReq = new PessoaResquest("lucas",  LocalDate.of(2000, 11, 20));
        return pessoaReq;
    }

    public static List<Pessoa> createListPessoa() {
        return List.of(Pessoa.builder().nome("Lucas").dataNascimento(LocalDate.of(2000, 11, 20)).enderecos(new ArrayList<>()).idPessoa(pessoaId).build(),
                Pessoa.builder().build(),
                Pessoa.builder().nome("Marcio").dataNascimento(LocalDate.of(2000, 11, 20)).enderecos(new ArrayList<>()).idPessoa(pessoaId).build(),
                Pessoa.builder().build());
    }


}