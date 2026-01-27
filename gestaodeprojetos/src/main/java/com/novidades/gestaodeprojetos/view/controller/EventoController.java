package com.novidades.gestaodeprojetos.view.controller;

import com.novidades.gestaodeprojetos.model.Evento;
import com.novidades.gestaodeprojetos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> obterTodosEventos() {
        return eventoService.obterTodosEventos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> obterEventoPorId(@PathVariable Long id) {
        return eventoService.obterEventoPorId(id);
    }

    @PostMapping
    public Evento adicionar(@RequestBody Evento evento) {
        return eventoService.adicionar(evento);
    }


    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return eventoService.atualizarEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(Long id) {
        eventoService.deletarEvento(id);
    }



}
