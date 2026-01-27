package br.com.marketcar.veiculos.service;

import br.com.marketcar.veiculos.shared.VeiculoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoService {
    VeiculoDto criarVeiculo(VeiculoDto veiculo);
    List<VeiculoDto> obterTodos();
    Optional<VeiculoDto>obterPorId(UUID id);
    List<VeiculoDto>obterPorProprietario(UUID proprietario);
    void removerVeiculo(UUID id);
    boolean venderVeiculo(UUID id);
    VeiculoDto atualizarVeiculo(UUID id, VeiculoDto veiculo);

}
