package com.meuexample.controle_de_pessoa.shared;

import java.util.List;
import java.util.UUID;

public class PessoaDto {
    private UUID id;
    private String nome;
    private String sobrenome;
    private List<AnimalDto> animais;

    //region de get e set


    public List<AnimalDto> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDto> animais) {
        this.animais = animais;
    }


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
