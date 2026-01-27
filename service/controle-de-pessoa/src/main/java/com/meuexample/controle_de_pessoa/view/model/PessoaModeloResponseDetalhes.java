package com.meuexample.controle_de_pessoa.view.model;

import com.meuexample.controle_de_pessoa.shared.AnimalDto;

import java.util.List;

public class PessoaModeloResponseDetalhes extends PessoaModeloResponse{

    private List<AnimalDto> animais;

    public List<AnimalDto> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDto> animais) {
        this.animais = animais;
    }
}
