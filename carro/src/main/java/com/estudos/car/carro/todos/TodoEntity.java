package com.estudos.car.carro.todos;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_todos")
public class TodoEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "concluido")
    private Boolean concluido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
}
