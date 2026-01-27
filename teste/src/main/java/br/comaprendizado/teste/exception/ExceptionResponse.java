package br.comaprendizado.teste.exception;

//Com a class recorde utilizamos para representar um objeto imutável, ou seja, seus atributos não podem ser alterados após a criação do objeto.
//Além disso, a class recorde gera automaticamente métodos como equals(), hashCode() e toString(), facilitando a manipulação dos dados.
//Com ess class ira ajudar a formatar a resposta de erro padronizada para o cliente, fornecendo informações úteis sobre o erro ocorrido.


import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
