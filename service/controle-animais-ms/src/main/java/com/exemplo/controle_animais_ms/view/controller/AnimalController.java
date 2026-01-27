package com.exemplo.controle_animais_ms.view.controller;

import com.exemplo.controle_animais_ms.service.AnimalService;
import com.exemplo.controle_animais_ms.shared.AnimalDto;
import com.exemplo.controle_animais_ms.view.model.AnimalModeloAlteracao;
import com.exemplo.controle_animais_ms.view.model.AnimalModeloInclusao;
import com.exemplo.controle_animais_ms.view.model.AnimalModeloResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/animais")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<AnimalModeloResponse> criarAnimal(@RequestBody @Valid AnimalModeloInclusao Animal) {
        ModelMapper mapper = new ModelMapper();
        AnimalDto dto = mapper.map(Animal, AnimalDto.class);

        dto = service.criarAnimal(dto);
        return new ResponseEntity<>(mapper.map(dto, AnimalModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnimalModeloResponse>> obterTodos() {
        List<AnimalDto> dtos = service.obterTodos();
        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ModelMapper mapper = new ModelMapper();
        List<AnimalModeloResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, AnimalModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{dono}/lista")
    public ResponseEntity<List<AnimalModeloResponse>> obterPorDono(@PathVariable UUID dono) {
        List<AnimalDto> dtos = service.obterPorDono(dono);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AnimalModeloResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, AnimalModeloResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AnimalModeloResponse> obterPorId(@PathVariable UUID id) {
        Optional<AnimalDto> Animal = service.obterPorId(id);

        if(Animal.isPresent()) {
            return new ResponseEntity<>(
                    new ModelMapper().map(Animal.get(), AnimalModeloResponse.class),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<AnimalModeloResponse> atualizarAnimal(@PathVariable UUID id,
                                                                @Valid @RequestBody AnimalModeloAlteracao Animal) {
        ModelMapper mapper = new ModelMapper();
        AnimalDto dto = mapper.map(Animal, AnimalDto.class);
        dto = service.atualizarAnimal(id, dto);

        return new ResponseEntity<>(mapper.map(dto, AnimalModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerAnimal(@PathVariable UUID id) {
        service.removerAnimal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Void> definirMorto(@PathVariable UUID id) {
        if(service.definirComoMorto(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
