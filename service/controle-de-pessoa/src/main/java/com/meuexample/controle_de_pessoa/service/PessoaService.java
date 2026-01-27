package com.meuexample.controle_de_pessoa.service;

import com.meuexample.controle_de_pessoa.shared.AnimalDto;
import com.meuexample.controle_de_pessoa.shared.PessoaDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PessoaService {

    PessoaDto criarPessoa(PessoaDto pessoaDto);
    List <PessoaDto> obterTodasPessoas();
    Optional<PessoaDto> obterPessoaPorId(UUID id);
    void deletarPessoa(UUID id);
    PessoaDto atualizarPessoa(UUID id, PessoaDto pessoaDto);


}
