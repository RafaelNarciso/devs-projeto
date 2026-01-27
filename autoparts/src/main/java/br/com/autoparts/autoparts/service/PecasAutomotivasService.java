package br.com.autoparts.autoparts.service;

import br.com.autoparts.autoparts.tratamentoexception.exception.ResourceNotFoundException;
import br.com.autoparts.autoparts.model.PecasAutomotivas;
import br.com.autoparts.autoparts.repository.PecasAutomotivasRepository;
import br.com.autoparts.autoparts.shared.PecasAutomotivasDTO;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service responsável por gerenciar as operações de CRUD para PecasAutomotivas.
 *
 * Utiliza ModelMapper para conversão entre entidades e DTOs.
 */
@Service
public class PecasAutomotivasService {

    @Autowired
    private final PecasAutomotivasRepository repository;

    private final ModelMapper mapper;

    /**
     * Construtor do service.
     *
     * @param repository Repositório de PecasAutomotivas
     * @param mapper ModelMapper para conversão entre entidade e DTO
     */
    public PecasAutomotivasService(PecasAutomotivasRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Retorna todas as peças do estoque como DTOs.
     *
     * @return Lista de PecasAutomotivasDTO
     */
    public List<PecasAutomotivasDTO> obterTodos() {
        List<PecasAutomotivas> pecas = repository.findAll();
        return pecas.stream()
                .map(p -> mapper.map(p, PecasAutomotivasDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Retorna uma peça específica pelo ID.
     *
     * @param id UUID da peça
     * @return Optional de PecasAutomotivasDTO contendo a peça encontrada
     * @throws ResourceNotFoundException se não houver peça com o ID informado
     */
    public Optional<PecasAutomotivasDTO> obterPorId(UUID id) {
        Optional<PecasAutomotivas> peca = repository.findById(id);

        if (peca.isEmpty()) {
            throw new ResourceNotFoundException("Peça não encontrada com o ID: " + id);
        }

        PecasAutomotivasDTO dto = mapper.map(peca.get(), PecasAutomotivasDTO.class);
        return Optional.of(dto);
    }

    /**
     * Adiciona uma nova peça ao estoque.
     *
     * @param pecaDto DTO contendo os dados da peça a ser criada
     * @return PecasAutomotivasDTO da peça criada
     */
    public PecasAutomotivasDTO adicionar(PecasAutomotivasDTO pecaDto) {
        PecasAutomotivas peca = mapper.map(pecaDto, PecasAutomotivas.class);
        PecasAutomotivas pecaSalva = repository.save(peca);
        return mapper.map(pecaSalva, PecasAutomotivasDTO.class);
    }

    /**
     * Atualiza uma peça existente no estoque.
     *
     * @param id UUID da peça a ser atualizada
     * @param pecaDto DTO contendo os campos a serem atualizados
     * @return PecasAutomotivasDTO da peça atualizada
     * @throws ResourceNotFoundException se não houver peça com o ID informado
     */
    public PecasAutomotivasDTO atualizar(UUID id, PecasAutomotivasDTO pecaDto) {
        PecasAutomotivas peca = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Peça não encontrada com o ID: " + id));

        // Atualiza apenas campos não nulos do DTO
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(pecaDto, peca);

        PecasAutomotivas pecaAtualizada = repository.save(peca);
        return mapper.map(pecaAtualizada, PecasAutomotivasDTO.class);
    }

    /**
     * Remove uma peça do estoque pelo ID.
     *
     * @param id UUID da peça a ser removida
     * @throws ResourceNotFoundException se não houver peça com o ID informado
     */
    public void deletar(UUID id) {
        PecasAutomotivas peca = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Peça não encontrada com o ID: " + id));
        repository.delete(peca);
    }

}
