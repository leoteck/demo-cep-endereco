package com.desafio.cepws.core.exception;

public class ProcessamentoCEPException extends RuntimeException {

    public ProcessamentoCEPException(String message) {
        super(message);
    }

    public ProcessamentoCEPException(String message, Throwable cause) {
        super(message, cause);
    }
}
