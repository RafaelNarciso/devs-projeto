package com.novidades.gestaodeprojetos.service;

import com.novidades.gestaodeprojetos.model.Categoria;
import com.novidades.gestaodeprojetos.model.Evento;
import com.novidades.gestaodeprojetos.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> obterTodosEventos() {

        return categoriaRepository.findAll();
    }

    public Optional<Categoria>obterEventoPorId(Long id) {

        return categoriaRepository.findById(id);
    }

    public  Categoria adicionar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Categoria atualizarEvento(Long id, Categoria categoria) {
        //evento.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletarEvento(Long id) {
        categoriaRepository.deleteById(id);
    }
}
