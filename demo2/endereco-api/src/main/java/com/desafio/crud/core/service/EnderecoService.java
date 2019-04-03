package com.desafio.crud.core.service;

import com.desafio.crud.core.exception.EnderecoNotFoundException;
import com.desafio.crud.core.exception.EnderecoPersistenceException;
import com.desafio.crud.core.model.Endereco;
import com.desafio.crud.core.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.desafio.crud.core.exception.EnderecoPersistenceException.EnderecoPersistenceEnum.DELETE;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco save(Endereco endereco){
        return this.enderecoRepository.save(endereco);
    }

    @Transactional
    public Endereco update(Endereco endereco){
        return this.enderecoRepository.save(endereco);
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
