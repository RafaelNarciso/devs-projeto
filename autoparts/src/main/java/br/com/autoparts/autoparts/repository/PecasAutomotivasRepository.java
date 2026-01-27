package br.com.autoparts.autoparts.repository;

import br.com.autoparts.autoparts.model.PecasAutomotivas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PecasAutomotivasRepository extends JpaRepository<PecasAutomotivas, UUID> {

}
