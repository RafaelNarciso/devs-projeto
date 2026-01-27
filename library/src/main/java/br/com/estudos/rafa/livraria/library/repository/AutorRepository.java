package br.com.estudos.rafa.livraria.library.repository;

import br.com.estudos.rafa.livraria.library.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository <Autor, UUID > {

}
