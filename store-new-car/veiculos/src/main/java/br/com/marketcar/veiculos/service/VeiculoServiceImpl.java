package br.com.marketcar.veiculos.service;

import br.com.marketcar.veiculos.model.Veiculo;
import br.com.marketcar.veiculos.repository.VeiculoRepository;
import br.com.marketcar.veiculos.shared.VeiculoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    @Override
    public VeiculoDto criarVeiculo(VeiculoDto veiculo) {
        return salvarVeiculo(veiculo);
    }

    @Override
    public List<VeiculoDto> obterTodos() {
        List<Veiculo> veiculos = repo.findAll();
        return veiculos.stream()
                .map(veiculo -> new ModelMapper().map(veiculo, VeiculoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoDto> obterPorId(UUID id) {
        Optional<Veiculo>veiculo = repo.findById(id);
        if(veiculo.isPresent()) {
            return Optional.of(new ModelMapper().map(veiculo.get(), VeiculoDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<VeiculoDto> obterPorProprietario(UUID proprietario) {
        List<Veiculo> veiculos = repo.findByProprietario(proprietario);
        return veiculos.stream()
                .map(veiculo -> new ModelMapper().map(veiculo, VeiculoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removerVeiculo(UUID id) {
        repo.deleteById(id);

    }

    @Override
    public boolean venderVeiculo(UUID id) {

        return venderVeiculo(id);
    }

    @Override
    public VeiculoDto atualizarVeiculo(UUID id, VeiculoDto veiculo) {
        veiculo.setId(id);
        return atualizarVeiculo(id, veiculo);
    }

    private VeiculoDto salvarVeiculo(VeiculoDto veiculodto) {

        ModelMapper mapper = new ModelMapper();
        Veiculo veiculo = mapper.map(veiculodto, Veiculo.class);
        veiculo = repo.save(veiculo);
        return mapper.map(veiculo, VeiculoDto.class);

    }

}
