package com.estudos.car.carro.todos.controller;


import com.estudos.car.carro.todos.TodoEntity;
import com.estudos.car.carro.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todos")
public class TodoController {


    private TodoService service;

    public TodoController (TodoService service) {
        this.service = service;
    }

    public TodoEntity salvar(@RequestBody TodoEntity todo ) {
        return this.service.salvar(todo);

    }


}
