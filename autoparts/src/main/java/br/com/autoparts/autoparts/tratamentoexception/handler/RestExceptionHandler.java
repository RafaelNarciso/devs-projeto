package br.com.autoparts.autoparts.tratamentoexception.handler;

import br.com.autoparts.autoparts.tratamentoexception.error.ErrorMenssage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RestExceptionHandler {

    public ResponseEntity<?> handleResourceNotFoundException(Exception ex) {
        ErrorMenssage erro = new ErrorMenssage(
                "Not Found",
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                java.time.LocalDate.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
