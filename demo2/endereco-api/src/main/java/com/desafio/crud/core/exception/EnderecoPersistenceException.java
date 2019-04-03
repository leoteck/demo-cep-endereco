package com.desafio.crud.core.exception;

public class EnderecoPersistenceException extends EnderecoException {

    public EnderecoPersistenceException(String message) {super(message);}
    public EnderecoPersistenceException(EnderecoPersistenceEnum tipoPersistence, String message) {
        super("Erro ao efetuar " + tipoPersistence.description +": " + message);
    }

    public enum EnderecoPersistenceEnum {
        CREATE("Inclusão"), UPDATE("Atualização"), DELETE("Exclusão");

        private String description;

        EnderecoPersistenceEnum(String description){
            this.description = description;
        }
    }
}
