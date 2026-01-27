package com.exemplo.controle_animais_ms.view.model;

import java.util.UUID;

public class AnimalModeloResponse {
    private UUID id;
    private UUID dono;
    private String nome;
    private Integer idade;
    private String raca;
    private Boolean vivo;

    //#region Get / Set


    public String getNome() {
        return nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDono() {
        return dono;
    }

    public void setDono(UUID dono) {
        this.dono = dono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
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

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }
    //#endregion
}
