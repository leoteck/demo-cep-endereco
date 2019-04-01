package com.desafio.cepws.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String rua;//logradouro
    private String bairro;
    private String cidade;//localidade
    private String estado;//uf

    public Endereco(String cep, String rua, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
