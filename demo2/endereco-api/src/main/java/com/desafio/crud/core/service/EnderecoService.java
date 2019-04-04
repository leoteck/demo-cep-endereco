package com.desafio.crud.core.service;

import com.desafio.crud.consumer.CepApiRestClientConsumer;
import com.desafio.crud.core.exception.EnderecoNotFoundException;
import com.desafio.crud.core.exception.EnderecoPersistenceException;
import com.desafio.crud.core.model.Endereco;
import com.desafio.crud.core.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.desafio.crud.core.exception.EnderecoPersistenceException.EnderecoPersistenceEnum.CREATE_UPDATE;
import static com.desafio.crud.core.exception.EnderecoPersistenceException.EnderecoPersistenceEnum.DELETE;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CepApiRestClientConsumer cepApiRestClientConsumer;

    @Transactional
    public Endereco save(Endereco endereco){
        cepApiRestClientConsumer.getEnderecoByCEP(endereco.getCep());
        try {
            return this.enderecoRepository.save(endereco);
        }catch(Exception ex) {
            throw new EnderecoPersistenceException(CREATE_UPDATE, ex.getMessage());
        }
    }

    @Transactional
    public Endereco update(Endereco endereco){
        return this.save(endereco);
    }

    @Transactional
    public void delete(Long id) throws Exception{
        try {
            Endereco endereco = findById(id);
            this.enderecoRepository.delete(endereco);
        } catch (EnderecoNotFoundException ex) {
            throw new EnderecoPersistenceException(DELETE, ex.getMessage());
        }
    }

    public Endereco findById(Long id) throws Exception {
        return this.enderecoRepository.findById(id).orElseThrow(() -> new EnderecoNotFoundException());
    }

    public List<Endereco> findAll() {
        return this.enderecoRepository.findAll();
    }
}
