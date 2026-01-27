package com.meuexample.controle_de_pessoa.view.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.meuexample.controle_de_pessoa.http.AnimaisFeignClient;
import com.meuexample.controle_de_pessoa.service.PessoaService;
import com.meuexample.controle_de_pessoa.shared.PessoaDto;
import com.meuexample.controle_de_pessoa.view.model.PessoaModeloRequest;
import com.meuexample.controle_de_pessoa.view.model.PessoaModeloResponse;
import com.meuexample.controle_de_pessoa.view.model.PessoaModeloResponseDetalhes;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meuexample.controle_de_pessoa.model.Pessoa;


@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }


    @PostMapping
    public ResponseEntity<PessoaModeloResponse> criarPessoa(@RequestBody @Valid PessoaModeloRequest pessoa) {
        ModelMapper mapper = new ModelMapper();
        PessoaDto dto = mapper.map(pessoa, PessoaDto.class);
        dto = service.criarPessoa(dto);
        return new ResponseEntity<>(mapper.map(dto, PessoaModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaModeloResponse>> obterTodos() {
        List<PessoaDto> dtos = service.obterTodasPessoas();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<PessoaModeloResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, PessoaModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PessoaModeloResponse> obterPorId(@PathVariable UUID id) {
        Optional<PessoaDto> pessoa = service.obterPessoaPorId(id);

        if(pessoa.isPresent()) {
            return new ResponseEntity<>(
                    new ModelMapper().map(pessoa.get(), PessoaModeloResponse.class),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PessoaModeloResponse> atualizarPessoa(@PathVariable UUID id,
                                                                @Valid @RequestBody Pessoa pessoa) {
        ModelMapper mapper = new ModelMapper();
        PessoaDto dto = mapper.map(pessoa, PessoaDto.class);
        dto = service.atualizarPessoa(id, dto);

        return new ResponseEntity<>(mapper.map(dto, PessoaModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerPessoa(@PathVariable UUID id) {
        service.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
