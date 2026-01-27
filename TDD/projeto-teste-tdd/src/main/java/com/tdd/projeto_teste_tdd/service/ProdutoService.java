package com.tdd.projeto_teste_tdd.service;

import com.tdd.projeto_teste_tdd.model.Produto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {


    public List<Produto> obterTodos() {
        List<Produto> produtos = new ArrayList<Produto>();
        return produtos;
    }

    public Optional<Produto> obterPorId( UUID id){
        Optional<Produto> produtos = Optional.of(new Produto());
        return produtos;
    }

    public Produto adicionar(Produto produto){
        return produto;
    }

}
