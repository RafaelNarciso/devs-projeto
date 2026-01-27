package com.exemplo.controle_animais_ms.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.exemplo.controle_animais_ms.shared.AnimalDto;


public interface  AnimalService {
    AnimalDto criarAnimal(AnimalDto animal);
    List<AnimalDto> obterTodos();
    Optional<AnimalDto> obterPorId(UUID id);
    List<AnimalDto> obterPorDono(UUID dono);
    void removerAnimal(UUID id);
    boolean definirComoMorto(UUID id);
    AnimalDto atualizarAnimal(UUID id, AnimalDto animal);
}
