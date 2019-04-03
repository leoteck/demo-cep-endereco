package com.desafio.crud.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotNull(message = "cep é obrigatório")
    @Column(name = "cep")
    private String cep;
    @NotNull(message = "rua é obrigatório")
    @Column(name = "rua")
    private String rua;//logradouro
    @NotNull(message = "numero é obrigatório")
    @Column(name = "numero")
    private String numero;
    @NotNull(message = "cidade é obrigatório")
    @Column(name = "cidade")
    private String cidade;//localidade
    @NotNull(message = "estado é obrigatório")
    @Column(name = "estado")
    private String estado;//uf
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "complemento")
    private String complemento;

    /*public Endereco(String cep, String rua, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }*/
}