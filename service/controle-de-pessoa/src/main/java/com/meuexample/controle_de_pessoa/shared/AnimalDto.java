package com.meuexample.controle_de_pessoa.shared;

import java.util.UUID;

public class AnimalDto {
    private UUID id;
    private UUID dono;
    private String nome;
    private Integer idade;
    private String raca;
    private Boolean vivo;

    //#region getter e setter
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

    public String getNome() {
        return nome;
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
