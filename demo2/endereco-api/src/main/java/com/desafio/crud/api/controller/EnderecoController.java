package com.desafio.crud.api.controller;

import com.desafio.crud.consumer.CepApiRestClientConsumer;
import com.desafio.crud.core.model.Endereco;
import com.desafio.crud.core.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/enderecos", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CepApiRestClientConsumer cepApiRestClientConsumer;

    @PostMapping
    public ResponseEntity incluirEndereco(@RequestBody @Valid Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    @PutMapping
    public ResponseEntity atualizarEndereco(@RequestBody @Valid Endereco endereco){
        return ResponseEntity.ok(enderecoService.update(endereco));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity buscarEnderecoPorId(@PathVariable("id") Long id) {
        try{
            return ResponseEntity.ok(enderecoService.findById(id));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity buscarTodosEnderecos() {
        try{
            return ResponseEntity.ok(enderecoService.findAll());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluirEndereco(@PathVariable String id) throws Exception {
        enderecoService.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }
}
