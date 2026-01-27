package com.meuexample.controle_de_pessoa.repository;

import com.meuexample.controle_de_pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository <Pessoa, UUID > {

}
