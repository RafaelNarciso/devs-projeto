package br.com.marketcar.veiculos.repository;

import br.com.marketcar.veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
    List<Veiculo>findByProprietario(UUID proprietario);
}
