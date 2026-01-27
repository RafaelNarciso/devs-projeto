package br.com.compras.Produto.view.controller;

import br.com.compras.Produto.exception.ResourceNotFoundException;
import br.com.compras.Produto.model.Produto;
import br.com.compras.Produto.sevice.ProdutoService;
import br.com.compras.Produto.shared.ProdutoDTO;
import br.com.compras.Produto.view.model.ProdutoRequest;
import br.com.compras.Produto.view.model.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List <ProdutoResponse> > obterTodos() {

        List<ProdutoDTO> produto =  produtoService.obterTodos();
        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> response = produto.stream()
                .map(dto -> mapper.map(dto, ProdutoResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> obterPorId(@PathVariable UUID id) {
        Optional<ProdutoDTO> produtoDTO = produtoService.obterPorId(id);

        if (produtoDTO.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        ProdutoResponse response = new ModelMapper().map(produtoDTO.get(), ProdutoResponse.class);
        return ResponseEntity.ok(response); // 200
    }




    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable UUID id, @RequestBody ProdutoRequest produtoRequest) {


        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDTO = mapper.map(produtoRequest, ProdutoDTO.class);



        produtoDTO = produtoService.atualizar(id,produtoDTO);
        return new ResponseEntity<>(mapper.map(produtoDTO, ProdutoResponse.class), HttpStatus.OK);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable UUID id) {

        produtoService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}