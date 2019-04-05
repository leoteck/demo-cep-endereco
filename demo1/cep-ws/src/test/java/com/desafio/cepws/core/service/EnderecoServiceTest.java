package com.desafio.cepws.core.service;

import com.desafio.cepws.core.model.Endereco;
import com.desafio.cepws.core.process.ProcessamentoCEP;
import com.desafio.cepws.core.repository.EnderecoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.Optional;

import static com.desafio.cepws.core.util.ConstantsUtil.MESSAGE_CEP_NAO_ENCONTRADO;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EnderecoServiceTest {

    @Spy
    private EnderecoService enderecoService = new EnderecoService();

    @Mock
    private ProcessamentoCEP processamentoCEP;
    @Mock
    private EnderecoRepository enderecoRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(enderecoService, "enderecoRepository", enderecoRepository);
        ReflectionTestUtils.setField(enderecoService, "processamentoCEP", processamentoCEP);
    }

    @Test
    public void buscarEnderecoComCepNaoEncontrado() throws Exception {
        String cep = "41370045";
        when(enderecoRepository.findByCep(any(String.class))).thenReturn(Optional.empty());

        try {
            Optional<Endereco> endereco = enderecoService.buscarEndereco(cep, 8);
            fail("Exception não lançada");
        }catch(Exception e){
            Assert.assertEquals(MESSAGE_CEP_NAO_ENCONTRADO, e.getMessage());
        }
    }

}
