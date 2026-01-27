package com.meuexample.controle_de_pessoa.service;

import com.meuexample.controle_de_pessoa.http.AnimaisFeignClient;
import com.meuexample.controle_de_pessoa.model.Pessoa;
import com.meuexample.controle_de_pessoa.repository.PessoaRepository;
import com.meuexample.controle_de_pessoa.shared.AnimalDto;
import com.meuexample.controle_de_pessoa.shared.PessoaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository repo;
    @Autowired
    private AnimaisFeignClient animaisMsFeignClient;

    public PessoaServiceImpl(PessoaRepository repo, AnimaisFeignClient animaisMsFeignClient) {
        this.repo = repo;
        this.animaisMsFeignClient = animaisMsFeignClient;
    }

    @Override
    public PessoaDto criarPessoa(PessoaDto pessoa) {
        return salvarPessoa(pessoa);
    }

    @Override
    public List<PessoaDto> obterTodasPessoas() {
        List<Pessoa> pessoas = repo.findAll();

        return pessoas.stream()
                .map(pessoa -> new ModelMapper().map(pessoa, PessoaDto.class))
                .toList();
    }

    @Override
    public Optional<PessoaDto> obterPessoaPorId(UUID id) {
        Optional<Pessoa> pessoa = repo.findById(id);
        if (pessoa.isPresent()) {

            PessoaDto dto = new ModelMapper().map(pessoa.get(), PessoaDto.class);

            // Chamada Feign para obter os animais do dono
            try {
                List<AnimalDto> animais = animaisMsFeignClient.obterAnimais(id);
                dto.setAnimais(animais); // adiciona a lista de animais
            } catch (feign.FeignException.NotFound e) {
                dto.setAnimais(new ArrayList<>()); // caso não tenha animais
            } catch (Exception e) {
                // Loga e define lista vazia em caso de outros erros
                System.err.println("Erro ao buscar animais via Feign: " + e.getMessage());
                dto.setAnimais(new ArrayList<>());
            }

            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public void deletarPessoa(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public PessoaDto atualizarPessoa(UUID id, PessoaDto pessoa) {
        pessoa.setId(id);
        return salvarPessoa(pessoa);
    }



    private PessoaDto salvarPessoa(PessoaDto pessoaDto){
        ModelMapper mapper = new ModelMapper();
        Pessoa pessoa = mapper.map(pessoaDto, Pessoa.class);
        Pessoa pessoaSalva = repo.save(pessoa);

        return mapper.map(pessoaSalva, PessoaDto.class);

    }
}
