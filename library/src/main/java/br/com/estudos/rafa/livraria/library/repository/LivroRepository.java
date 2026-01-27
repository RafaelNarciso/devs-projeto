package br.com.estudos.rafa.livraria.library.repository;


import br.com.estudos.rafa.livraria.library.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
