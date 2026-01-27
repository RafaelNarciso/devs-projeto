package com.estudos.car.carro.todos.repository;

import com.estudos.car.carro.todos.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

}
