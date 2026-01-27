package com.meuexample.controle_de_pessoa.view.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PessoaModeloRequest {

    @NotBlank(message = "O nome deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 2, message = "O nome deve ter, no mínimo, 2 caracteres")
    private String nome;

    @NotBlank(message = "O sobrenome deve possuir caracteres não brancos")
    @NotEmpty(message = "O sobrenome deve ser preenchido")
    private String sobrenome;

    //region getters/setters

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    //endregion
}
