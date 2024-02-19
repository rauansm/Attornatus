package com.attornatus.AttornatusAPI.endereco.application.service;

import com.attornatus.AttornatusAPI.DataHelper;
import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoRequest;
import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoResponse;
import com.attornatus.AttornatusAPI.endereco.application.repository.EnderecoRepository;
import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EnderecoApplicationServiceTest {
    @Mock
    private EnderecoRepository enderecoRepository;
    @InjectMocks
    private EnderecoApplicationSerivce enderecoApplicationSerivce;
    @Mock
    private Endereco endereco;
    @Mock
    private PessoaRepository pessoaRepository;


        @Test
        void deveRetornarUmEnderecoNovoCriado() {
            Pessoa pessoa = DataHelper.createPessoa();
            UUID idPessoa = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
            EnderecoRequest request = DataHelper.getEnderecoRequest();
            when(pessoaRepository.buscaPessoaAtravesId(any(UUID.class))).thenReturn(pessoa);
            when(enderecoRepository.salva(any())).thenReturn(new Endereco(pessoa,request));
            EnderecoResponse response = enderecoApplicationSerivce.criaEndereco(idPessoa,request);

            assertNotNull(response);
            assertEquals(EnderecoResponse.class, response.getClass());
            assertEquals(request.getLogradouro(), response.getLogradouro());
            assertEquals(request.getCep(), response.getCep());
            assertEquals(request.getNumero(), response.getNumero());
            assertEquals(request.getCidade(), response.getCidade());
            assertEquals(UUID.class, response.getIdEndereco().getClass());
            assertEquals(idPessoa, response.getIdPessoa());

        }

        @Test
        void deveRetornarUmaListaDeEnderecos() {
            Pessoa pessoa = DataHelper.createPessoa();
            UUID idPessoa = pessoa.getIdPessoa();
            List<Endereco> enderecos = DataHelper.createListEndereco();
            when(pessoaRepository.buscaPessoaAtravesId(any(UUID.class))).thenReturn(pessoa);
            when(enderecoRepository.listaTodosEnderecosDaPessoa(any())).thenReturn(enderecos);
            List<EnderecoResponse> response = enderecoApplicationSerivce.listaTodosEnderecosDaPessoa(idPessoa);

            assertEquals(2,response.size());
            assertNotNull(response);
        }

        @Test
        void deveRetornarEnderecoDaPessoa(){
            UUID idPessoa = DataHelper.createPessoa().getIdPessoa();
            Endereco endereco = DataHelper.createEndereco();
            UUID idEndereco = endereco.getIdEndereco();
            when(enderecoRepository.buscaEnderecoDaPessoa(idPessoa,idEndereco)).thenReturn(endereco);
            Endereco enderecoResponse = enderecoApplicationSerivce.buscaEnderecoDaPessoa(idPessoa,idEndereco);

            assertNotNull(enderecoResponse);
            assertEquals(Endereco.class, enderecoResponse.getClass());
        }

        @Test
        void deveDefinirEnderecoComoPrincipal(){
            Pessoa pessoa = DataHelper.createPessoa();
            Endereco endereco = DataHelper.createEndereco();
            when(pessoaRepository.buscaPessoaAtravesId(any(UUID.class))).thenReturn(pessoa);
            when(enderecoRepository.buscaEnderecoDaPessoa(pessoa.getIdPessoa(),endereco.getIdEndereco())).thenReturn(endereco);
            enderecoApplicationSerivce.defineEnderecoPrincipal(pessoa.getIdPessoa(),endereco.getIdEndereco());
            verify(pessoaRepository, times(1)).buscaPessoaAtravesId(pessoa.getIdPessoa());
            verify(enderecoRepository, times(1)).buscaEnderecoDaPessoa(pessoa.getIdPessoa(),endereco.getIdEndereco());
            assertEquals(true, endereco.getEnderecoPrincipal());

        }
    
}
