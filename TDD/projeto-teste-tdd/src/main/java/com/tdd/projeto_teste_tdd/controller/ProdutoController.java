package com.tdd.projeto_teste_tdd.controller;

import com.tdd.projeto_teste_tdd.model.Produto;
import com.tdd.projeto_teste_tdd.service.ProdutoService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping()
    public ResponseEntity<List<Produto>>obterTodos(){

        List<Produto> produtos = produtoService.obterTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable UUID id){

        Optional<Produto> produtos = produtoService.obterPorId(id);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Produto>adicionar(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoService.adicionar(produto), HttpStatus.OK);
    }

}
