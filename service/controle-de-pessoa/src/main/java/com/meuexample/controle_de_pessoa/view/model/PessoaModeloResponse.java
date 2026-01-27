package com.meuexample.controle_de_pessoa.view.model;

import java.util.UUID;

public class PessoaModeloResponse {
    protected UUID id;
    protected String nome;
    protected String sobrenome;


    //region getters/setters

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    //endregion
}
