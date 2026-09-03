package com.nexticket.api.event.exception;

//nos lançamos uma excessão através dessa class
public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        super("Evento com id " + id + " não encontrado");
    }
}
