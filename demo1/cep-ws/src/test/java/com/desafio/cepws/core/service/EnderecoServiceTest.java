package com.desafio.cepws.core.service;

import com.desafio.cepws.core.model.Endereco;
import com.desafio.cepws.core.process.ProcessamentoCEP;
import com.desafio.cepws.core.repository.EnderecoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EnderecoServiceTest {

    @Spy
    private EnderecoService enderecoService = new EnderecoService();

    @Mock
    private ProcessamentoCEP processamentoCEP;
    @Mock
    private EnderecoRepository enderecoRepository;

   // @Test
    public void buscarEnderecoPorCep() throws Exception {
        String cep = "41370045";
        when(enderecoRepository.findByCep(any(String.class))).thenReturn(Optional.empty());

        Optional<Endereco> endereco = enderecoService.buscarEndereco(cep, 8);
        endereco.get().getCep();
        Assert.assertEquals(cep, endereco.get().getCep());
    }
}
