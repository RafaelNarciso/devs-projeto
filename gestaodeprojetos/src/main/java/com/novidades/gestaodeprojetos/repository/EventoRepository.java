package com.novidades.gestaodeprojetos.repository;

import com.novidades.gestaodeprojetos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {


}
