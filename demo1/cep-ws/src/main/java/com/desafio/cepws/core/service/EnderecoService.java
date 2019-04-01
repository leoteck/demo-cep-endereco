package com.desafio.cepws.core.service;

import com.desafio.cepws.core.model.Endereco;
import com.desafio.cepws.core.process.ProcessamentoCEP;
import com.desafio.cepws.core.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.desafio.cepws.core.util.ConstantsUtil.LENGTH_STRING_DIGITOS_CEP;


@Service
public class EnderecoService {

    @Autowired
    private ProcessamentoCEP processamentoCEP;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscarEnderecoPorCep(String cep) throws Exception {
        processamentoCEP.validar(cep);
        return buscarEndereco(cep, LENGTH_STRING_DIGITOS_CEP).get();
    }

    public Optional<Endereco> buscarEndereco(String cep, int iteracoesDigito) throws Exception {
        if (iteracoesDigito < 0) {
            throw new Exception("CEP não encontrado!");
        }
        Optional<Endereco> enderecoOptional = enderecoRepository.findByCep(cep);
        if (!enderecoOptional.isPresent()) {
            cep = processamentoCEP.substituirDigitoPorZero(cep, iteracoesDigito);
            return buscarEndereco(cep, --iteracoesDigito);
        }
        return enderecoOptional;
    }

}