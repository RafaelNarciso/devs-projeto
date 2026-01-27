package br.com.compras.Produto.view.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoResponse {


    //region Attributes

    private UUID id;

    private String nome;

    private Integer quantidade;

    private BigDecimal preco;

    private String descricao;
    //endregion

    //endregion

    //regions Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //endregion
}
