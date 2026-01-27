package br.com.marketcar.veiculos.view.controller;

import br.com.marketcar.veiculos.service.VeiculoService;
import br.com.marketcar.veiculos.shared.VeiculoDto;
import br.com.marketcar.veiculos.view.model.VeiculoModeloAlteracao;
import br.com.marketcar.veiculos.view.model.VeiculoModeloInclusao;
import br.com.marketcar.veiculos.view.model.VeiculoModeloResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping(value = "/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity <VeiculoModeloResponse> criarVeiculo(@RequestBody @Valid VeiculoModeloInclusao veiculo) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(veiculo, VeiculoDto.class);
        dto = service.criarVeiculo(dto);
        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoModeloResponse>> obterTodos() {
        List<VeiculoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{dono}/lista")
    public ResponseEntity<List<VeiculoModeloResponse>> obterPorDono(@PathVariable UUID dono) {
        List<VeiculoDto> dtos = service.obterPorProprietario(dono);
        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<VeiculoModeloResponse> obterPorId(@PathVariable UUID id) {
        Optional<VeiculoDto> Animal = service.obterPorId(id);

        if(Animal.isPresent()) {
            return new ResponseEntity<>(
                    new ModelMapper().map(Animal.get(), VeiculoModeloResponse.class),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<VeiculoModeloResponse> atualizarAnimal(@PathVariable UUID id,
                                                                @Valid @RequestBody VeiculoModeloAlteracao Animal) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(Animal, VeiculoDto.class);
        dto = service.atualizarVeiculo(id, dto);

        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerAnimal(@PathVariable UUID id) {
        service.removerVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
