package com.framework.framework.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TodoService {


    private final TodoRepository repository;
    private  TodoValidator validator;
    private   MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mailSender){
        this.repository =todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }



    public TodoEntity salvar (TodoEntity todo) {

        validator.validate(todo);
        return repository.save(todo);
    }


    public void atualizar (TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "concluido": "pendente";
        mailSender.enviar("A tarefa com ID " + todo.getId() + " foi atualizada.   "+ status);
    }

    public TodoEntity obterPorId (Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<TodoEntity> obterTodos() {
        return repository.findAll();
    }


    public void deletePorId (Integer id) {
        repository.deleteById(id);
    }







}
