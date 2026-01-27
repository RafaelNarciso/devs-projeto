package com.exemplo.controle_animais_ms.service;


import com.exemplo.controle_animais_ms.model.Animal;
import com.exemplo.controle_animais_ms.repository.AnimalRepository;
import com.exemplo.controle_animais_ms.shared.AnimalDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository repo;


    @Override
    public AnimalDto criarAnimal(AnimalDto animal) {
        return salvarAnimal(animal);
    }

    @Override
    public List<AnimalDto> obterTodos() {
        List<Animal> animais = repo.findAll();

        return animais.stream()
                .map(animal -> new ModelMapper().map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnimalDto> obterPorId(UUID id) {
        Optional<Animal> animal = repo.findById(id);

        if(animal.isPresent()) {
            return Optional.of(new ModelMapper().map(animal.get(), AnimalDto.class));
        }

        return Optional.empty();
    }

    @Override
    public List<AnimalDto> obterPorDono(UUID dono) {
        List<Animal> animais = repo.findByDono(dono);

        return animais.stream()
                .map(animal -> new ModelMapper().map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }




    @Override
    public void removerAnimal(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public boolean definirComoMorto(UUID id) {

        Optional<Animal> animal = repo.findById(id);
        if(animal.isPresent()) {
            animal.get().setVivo(false);
            repo.save(animal.get());

            return true;
        }

        return false;
    }


    @Override
    public AnimalDto atualizarAnimal(UUID id, AnimalDto animal) {
        animal.setId(id);
        return salvarAnimal(animal);
    }


    private AnimalDto salvarAnimal(AnimalDto animalDto) {
        ModelMapper mapper = new ModelMapper();
        Animal animal = mapper.map(animalDto, Animal.class);
        animal = repo.save(animal);

        return mapper.map(animal, AnimalDto.class);
    }


}
