package com.desafio.crud.api.handler;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error handler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private Error processFieldErrors(List<FieldError> fieldErrors) {
        Error error = new Error(BAD_REQUEST.value(), "Erro de validação de campos");
        for (FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getDefaultMessage());
        }
        return error;
    }

    static class Error {
        private final int status;
        private final String message;
        private List<String> fieldErrors = new ArrayList<>();

        Error(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public void addFieldError(String message) {
            fieldErrors.add(message);
        }

        public List<String> getFieldErrors() {
            return fieldErrors;
        }
    }
}
