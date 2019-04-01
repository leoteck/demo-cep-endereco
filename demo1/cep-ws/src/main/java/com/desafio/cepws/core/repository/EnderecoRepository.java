package com.desafio.cepws.core.repository;

import com.desafio.cepws.core.model.Endereco;
import com.desafio.cepws.core.util.EnderecoMockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Repository
@Component
public class EnderecoRepository {

    @Autowired
    private EnderecoMockUtil enderecoMockUtil;

    public Optional<Endereco> findByCep(String cep) {
        return enderecoMockUtil.getEnderecos().stream().filter(endereco -> endereco.getCep().equals(cep)).findFirst();
    }
}
