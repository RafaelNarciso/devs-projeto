package br.com.compras.Produto.handler;

import br.com.compras.Produto.error.ErrorMenssage;
import br.com.compras.Produto.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice // Indica que esta classe irá tratar exceções globalmente ele ira ficar escutando as exceções que acontecerem na aplicação
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)// Indica que este metodo ira tratar a exceção ResourceNotFoundException
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMenssage erro = new ErrorMenssage("Not found", HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
