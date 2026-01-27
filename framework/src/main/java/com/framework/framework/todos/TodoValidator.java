package com.framework.framework.todos;

import org.springframework.stereotype.Component;


@Component
public class TodoValidator {

    private final TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validate(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDesciricao())){
            throw new IllegalArgumentException("Já existe uma tarefa com a mesma descrição.");
        }

    }

    public boolean existeTodoComDescricao(String descricao) {
        return repository.existsByDesciricao(descricao);
    }
}

