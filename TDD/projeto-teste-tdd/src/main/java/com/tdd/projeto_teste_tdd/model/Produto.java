package com.tdd.projeto_teste_tdd.model;

import java.util.UUID;

public class Produto {

    private UUID id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private Double acrescimo;
    private Double desconto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double calcularValorTotal() {
        double valorTotal = valor * quantidade;

        if (acrescimo != null) {
            valorTotal += acrescimo;
        }
        if (desconto != null) {
            valorTotal -= desconto;
        }
        return valorTotal;
    }
}
