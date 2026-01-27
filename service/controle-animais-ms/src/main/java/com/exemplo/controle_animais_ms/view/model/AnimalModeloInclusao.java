package com.exemplo.controle_animais_ms.view.model;



import java.util.UUID;

public class AnimalModeloInclusao {
    private UUID dono;
    private String nome;
    private Integer idade;
    private String raca;

    //#region Get / Set


    public Integer getIdade() {
        return idade;
    }

    public UUID getDono() {
        return dono;
    }

    public void setDono(UUID dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    //#endregion
}

