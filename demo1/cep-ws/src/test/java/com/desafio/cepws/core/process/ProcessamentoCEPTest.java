package com.desafio.cepws.core.process;

import com.desafio.cepws.core.exception.ProcessamentoCEPException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.*;

public class ProcessamentoCEPTest {

    @Spy
    private ProcessamentoCEP validadorCEP = new ProcessamentoCEP();

    @Test
    public void substituirUltimoDigitoPorZero() {
        String cep =         "41370045";
        String cepEsperado = "41370040";
        int indiceUltimoDigito = 7;

        String novoCep = validadorCEP.substituirDigitoPorZero(cep, indiceUltimoDigito);
        assertEquals(cepEsperado, novoCep);
    }

    @Test
    public void substituirPrimeiroDigitoPorZero() {
        String cep =         "41370045";
        String cepEsperado = "01370045";
        int indiceUltimoDigito = 0;

        String novoCep = validadorCEP.substituirDigitoPorZero(cep, indiceUltimoDigito);
        assertEquals(cepEsperado, novoCep);
    }

    @Test
    public void validarCepSomenteComDigitos() {
        String cep = "41370045";
        boolean novoCep = validadorCEP.validar(cep);
        assertTrue(novoCep);
    }

    @Test
    public void validarCepEntradaComLetrasException() {
        String cep = "4137004S";
        String mensagemEsperada = "CEP Inválido!";
        try {
            boolean novoCep = validadorCEP.validar(cep);
            fail("ProcessamentoCEPException não lançada");
        } catch (ProcessamentoCEPException e) {
            assertEquals(mensagemEsperada, e.getMessage());
        }
    }

    @Test
    public void validarCepQuantidadeDigitosMenorQueOValidoException() {
        String cep = "413700";
        String mensagemEsperada = "CEP Inválido!";
        try {
            boolean novoCep = validadorCEP.validar(cep);
            fail("ProcessamentoCEPException não lançada");
        } catch (ProcessamentoCEPException e) {
            assertEquals(mensagemEsperada, e.getMessage());
        }
    }

    @Test
    public void validarCepQuantidadeDigitosMaiorQueOValidoException() {
        String cep = "413700455";
        String mensagemEsperada = "CEP Inválido!";
        try {
            boolean novoCep = validadorCEP.validar(cep);
            fail("ProcessamentoCEPException não lançada");
        } catch (ProcessamentoCEPException e) {
            assertEquals(mensagemEsperada, e.getMessage());
        }
    }
}
