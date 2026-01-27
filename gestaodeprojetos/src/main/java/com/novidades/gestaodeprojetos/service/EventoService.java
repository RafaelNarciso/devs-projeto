package com.novidades.gestaodeprojetos.service;

import com.novidades.gestaodeprojetos.model.Evento;
import com.novidades.gestaodeprojetos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obterTodosEventos() {
        return eventoRepository.findAll();
    }
    public Optional<Evento>obterEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }
    public  Evento adicionar(Evento evento) {
        return eventoRepository.save(evento);
    }
    public Evento atualizarEvento(Long id, Evento evento) {
        //evento.setId(id);
        return eventoRepository.save(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
