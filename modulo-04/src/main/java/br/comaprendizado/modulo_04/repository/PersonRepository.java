package br.comaprendizado.modulo_04.repository;

import br.comaprendizado.modulo_04.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
