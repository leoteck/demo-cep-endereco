package com.desafio.crud.consumer;

import com.desafio.crud.core.exception.CepApiClientConsumerException;
import com.desafio.crud.core.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.desafio.crud.core.util.ConstantsUtil.URL_SERVICE_CEP;

@Component
public class CepApiRestClientConsumer {

    @Autowired
    private RestTemplate restTemplate;

    public Endereco getEnderecoByCEP(String cep) {
        URI uri = UriComponentsBuilder.fromUriString(URL_SERVICE_CEP + cep).build().toUri();
        try {
            return restTemplate.getForObject(uri, Endereco.class);
        }catch(Exception e) {
            String messageError = ((org.springframework.web.client.HttpStatusCodeException) e).getResponseBodyAsString();
            throw new CepApiClientConsumerException(messageError);
        }
    }
}
