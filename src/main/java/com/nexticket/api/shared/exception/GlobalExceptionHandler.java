package com.nexticket.api.shared.exception;

import com.nexticket.api.event.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//nós tratamos a excessão através dessa classe
//RestControllerAdvice = Essa classe fica observando exceções lançadas pelos controllers da aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    //@ExceptionHandler = Quando Acontecer o EventNotFoundException, execute esse método
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            EventNotFoundException exception) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "Not Found",
                "message", exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
