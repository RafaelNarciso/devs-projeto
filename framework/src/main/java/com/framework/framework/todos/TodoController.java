package com.framework.framework.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todos){
        try {
            return  this.service.salvar(todos);
        }catch (IllegalArgumentException e){
            var mensagem = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagem);
        }
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        this.service.atualizar(todo);
    }

    @GetMapping("/{id}")
    public TodoEntity obterPorId(@PathVariable("id") Integer id) {
        return this.service.obterPorId(id);
    }
    @GetMapping
    public List<TodoEntity> obterTodos() {
        return this.service.obterTodos();

    }

    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable("id") Integer id) {
        this.service.deletePorId(id);
    }

}
