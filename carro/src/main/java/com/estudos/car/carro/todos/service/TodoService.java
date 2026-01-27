package com.estudos.car.carro.todos.service;

import com.estudos.car.carro.todos.TodoEntity;
import com.estudos.car.carro.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TodoService {


    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoEntity salvar(TodoEntity todo) {
        return repository.save(todo);
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody TodoEntity todo,@PathVariable Integer id) {
        todo.setId(id);
        repository.save(todo);
    }


}
