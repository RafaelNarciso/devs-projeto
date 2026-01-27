package com.tdd.projeto_teste_tdd.model;

public class Comissao {

    public double calcularComissao(double valorVenda) {

        return  valorVenda > 1000.0 ? valorVenda * 0.15: valorVenda * 0.10;

//        if (valorVenda >= 1000) {
//            return valorVenda * 0.15;
//        } else if (valorVenda >= 500) {
//            return valorVenda * 0.1;
//        } else if (valorVenda >= 200) {
//            return valorVenda * 0.05;
//        } else {
//            return 0;
//        }
    }
    public static double calcularAreaCircle(double raio) {
        return Math.PI * raio * raio;
    }

}
