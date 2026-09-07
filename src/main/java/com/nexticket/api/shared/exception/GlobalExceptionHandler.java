package com.nexticket.api.shared.exception;

import com.nexticket.api.event.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

// Indica que esta classe será responsável por tratar exceções
// lançadas pelos controllers da aplicação.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata especificamente a exceção lançada quando
    // um evento não é encontrado pelo ID.
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            EventNotFoundException exception) {

        // Monta o corpo da resposta que será convertido para JSON.
        Map<String, Object> body = Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "Not Found",
                "message", exception.getMessage()
        );

        // Retorna HTTP 404 junto com o JSON contendo os detalhes do erro.
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

    // Trata os erros de validação gerados pelo @Valid.
    // Essa exceção ocorre quando algum campo do DTO não respeita
    // regras como @NotBlank, @NotNull, @Future ou @Positive.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        // Obtém todos os erros de validação encontrados pelo Spring
        // e transforma a lista de erros em um Map:
        //
        // nomeDoCampo -> mensagemDeErro
        //
        // Exemplo:
        // "name" -> "O nome do evento é obrigatório"
        // "capacity" -> "A capacidade deve ser maior que zero"
        Map<String, String> fields = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,

                        // Caso o mesmo campo tenha mais de um erro,
                        // mantemos a primeira mensagem encontrada.
                        (firstMessage, secondMessage) -> firstMessage
                ));

        // Monta uma resposta padronizada contendo:
        // status HTTP, tipo do erro, mensagem geral
        // e os campos que falharam na validação.
        Map<String, Object> body = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Bad Request",
                "message", "Dados inválidos",
                "fields", fields
        );

        // Retorna HTTP 400 (Bad Request) porque os dados enviados
        // pelo cliente não passaram pelas regras de validação.
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);
    }
}
