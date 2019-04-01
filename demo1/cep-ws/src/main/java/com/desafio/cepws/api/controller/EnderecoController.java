package com.desafio.cepws.api.controller;

import com.desafio.cepws.core.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity buscarEnderecoPorCep(@PathVariable("cep") String cep) {
        try {
            return ResponseEntity.ok(enderecoService.buscarEnderecoPorCep(cep));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }
}
