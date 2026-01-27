package com.exemplo.controle_animais_ms.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.controle_animais_ms.model.Animal;



@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID > {

    List<Animal> findByDono(UUID dono);

}

