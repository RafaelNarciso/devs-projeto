package br.com.estudosrafa.produtosApi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Date dataCriacao;
    private Integer quantidadeEstoque;

    //#region Getters e Setters

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    //#endregion


    @Override
    public String toString() {
        return "🛒 Produto" +
                "🆔 id=" + id +
                ", 🏷️ nome='" + nome + '\'' +
                ", 💲 preço=" + preco +
                ", 📝 descrição='" + descricao + '\'' +
                ", 📅 dataCriacao=" + dataCriacao +
                ", 📦 quantidadeEstoque=" + quantidadeEstoque ;
    }

}
