package br.com.estudosrafa.produtosApi.controller;

import br.com.estudosrafa.produtosApi.model.Produto;
import br.com.estudosrafa.produtosApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar (@RequestBody Produto produto){
        System.out.println("Produto salvo: " + produto.getNome());
        produto.setId(null);
        produto.setDataCriacao(new Date());
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> obterTodos() {
        return produtoRepository.findAll();

    }

    @GetMapping("/{id}")
    public Produto  obterPorId(@PathVariable("id") UUID id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable("id") UUID id) {
        produtoRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable("id") UUID id) {
        produto.setId(id);
        produto.setDataCriacao(new Date());
        return produtoRepository.save(produto);
    }

    @GetMapping("/buscarPorNome")
    public List<Produto>buscarPorNome(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }



}
