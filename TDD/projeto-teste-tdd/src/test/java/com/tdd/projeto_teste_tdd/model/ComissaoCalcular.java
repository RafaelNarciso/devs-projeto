package com.tdd.projeto_teste_tdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ComissaoCalcular {
    @TestConfiguration
    static class ComissaoConfiguracao {


        @Bean
        public Comissao comissao() {
            return new Comissao();
        }
    }

    @Autowired
    Comissao comissao;

    @Test
    public void testCalcularComissao10() {
        Double valorVenda = 1000.0;
        Double valorComissaoEsperado = 100.0;
        Double valorComissaoCalculado = comissao.calcularComissao(valorVenda);
        Assertions.assertEquals(valorComissaoEsperado, valorComissaoCalculado);
    }


    @Test
    public void testCalcularComissao300() {
        Double valorVenda = 2000.0;
        Double valorComissaoEsperado = 300.0;
        Double valorComissaoCalculado = comissao.calcularComissao(valorVenda);
        Assertions.assertEquals(valorComissaoEsperado, valorComissaoCalculado);
    }


    @Test
    public void testCalcularComissao50() {
        Double valorVenda = 500.0;
        Double valorComissaoEsperado = 50.0;
        Double valorComissaoCalculado = comissao.calcularComissao(valorVenda);
        Assertions.assertEquals(valorComissaoEsperado, valorComissaoCalculado);
    }

    @Test
    public void testeAdd(){
        int resultado = 2 + 2;
        Assertions.assertEquals(4, resultado);

    }

    @Test
    void testCalcularAreaCircle() {
        double raio = 3.0;
        double areaEsperada = Math.PI * raio * raio;
        double areaCalculada = Comissao.calcularAreaCircle(raio);
        Assertions.assertEquals(areaEsperada, areaCalculada, 0.0001);
    }

}
