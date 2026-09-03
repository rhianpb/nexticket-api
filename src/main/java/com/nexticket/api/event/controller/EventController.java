package com.nexticket.api.event.controller;

import com.nexticket.api.event.dto.CreateEventRequest;
import com.nexticket.api.event.entity.Event;
import com.nexticket.api.event.service.EventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
//EventController = camada HTTP
public class EventController {
    //final = Só poderá ser atribuida essa referência uma unica vez
    //Bean = objeto cuja criação e ciclo de vida são gerenciados pelo spring
    //injeção de dependência via construtor
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    //injeção de dependência via construtor

    @GetMapping
    public List<Event> listEvents() {
        return eventService.listEvents();
    }

    //valid = manda o Spring efetivamente validar o objeto recebido.
    @PostMapping
    public Event createEvent(@Valid @RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    //PathVariable = vai capturar os id
    @GetMapping("/{id}")
    public Event findById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    //mapear o put
    @PutMapping("/{id}")
    public Event updateEvent(
            //@RequestBody = pega os novos dados enviados no JSON
            //@PathVariable = pega id da url
            @PathVariable Long id,
            @Valid @RequestBody CreateEventRequest request) {

        return eventService.updateEvent(id, request);
    }
}
