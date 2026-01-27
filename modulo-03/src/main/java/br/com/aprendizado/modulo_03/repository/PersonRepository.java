package br.com.aprendizado.modulo_03.repository;

import br.com.aprendizado.modulo_03.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
