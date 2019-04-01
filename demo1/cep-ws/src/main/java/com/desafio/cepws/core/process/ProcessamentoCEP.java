package com.desafio.cepws.core.process;

import com.desafio.cepws.core.exception.ProcessamentoCEPException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.desafio.cepws.core.util.ConstantsUtil.TOTAL_DIGITOS_CEP;

@Component
public class ProcessamentoCEP {


    public boolean validar(String cep) throws ProcessamentoCEPException {
        if (validarQuantidadeDigitos(cep) || validarSomenteDigitos(cep)) {
            throw new ProcessamentoCEPException("CEP Inválido!");
        }
        return true;
    }

    private boolean validarSomenteDigitos(String cep) {
        Pattern p = Pattern.compile("\\d+(\\d+)?");
        return !p.matcher(cep).matches();
    }

    private boolean validarQuantidadeDigitos(String cep) {
        return cep.length() != TOTAL_DIGITOS_CEP;
    }

    public String substituirDigitoPorZero(String cep, int indiceDigitoASubstituir) {
        String []arr = cep.split("");
        arr[indiceDigitoASubstituir] = "0";
        String novoCep = String.join("", arr);
        return novoCep;
    }
}
