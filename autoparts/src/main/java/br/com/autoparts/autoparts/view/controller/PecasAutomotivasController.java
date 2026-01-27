package br.com.autoparts.autoparts.view.controller;

import br.com.autoparts.autoparts.service.PecasAutomotivasService;
import br.com.autoparts.autoparts.shared.PecasAutomotivasDTO;
import br.com.autoparts.autoparts.tratamentoexception.exception.ResourceNotFoundException;
import br.com.autoparts.autoparts.view.model.PecasAutomotivasResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/pecas/v1/automotivas")
public class PecasAutomotivasController {

    private final PecasAutomotivasService pecasAutomotivasService;
    private final ModelMapper modelMapper;

    public PecasAutomotivasController(PecasAutomotivasService pecasAutomotivasService, ModelMapper modelMapper) {
        this.pecasAutomotivasService = pecasAutomotivasService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<PecasAutomotivasDTO>> obterTodos() {
        List<PecasAutomotivasDTO> pecas = pecasAutomotivasService.obterTodos();
        return ResponseEntity.ok(pecas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecasAutomotivasDTO> obterPorId(@PathVariable UUID id) {
        PecasAutomotivasDTO peca = pecasAutomotivasService.obterPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Peça não encontrada"));
        return ResponseEntity.ok(peca);
    }

    @PostMapping
    public ResponseEntity<PecasAutomotivasDTO> adicionar(@RequestBody PecasAutomotivasDTO pecaDto) {
        PecasAutomotivasDTO pecaSalva = pecasAutomotivasService.adicionar(pecaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pecaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PecasAutomotivasDTO> atualizar(@PathVariable UUID id, @RequestBody PecasAutomotivasDTO pecaDto) {
        PecasAutomotivasDTO pecaAtualizada = pecasAutomotivasService.atualizar(id, pecaDto);
        return ResponseEntity.ok(pecaAtualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        pecasAutomotivasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
