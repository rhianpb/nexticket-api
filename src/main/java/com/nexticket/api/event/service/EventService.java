package com.nexticket.api.event.service;

import com.nexticket.api.event.dto.CreateEventRequest;
import com.nexticket.api.event.entity.Event;
import com.nexticket.api.event.exception.EventNotFoundException;
import com.nexticket.api.event.repository.EventRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Esta classe é um componente de serviço da aplicação.
@Service
//service = regra de negócio
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> listEvents() {
        return eventRepository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );
    }

    public Event createEvent(CreateEventRequest request) {

        Event event = new Event();

        event.setName(request.getName());
        event.setLocation(request.getLocation());

        return eventRepository.save(event);
    }

    //buscar no banco um evento que tenha um determinado id
    //findById = retorna um optional<event> pode existir ou não
    public Event findById(Long id){
        return eventRepository.findById(id)
                //.OrElseThrow = se encontrou um evento, devolva-o, se não encontrou, lance uma exceção
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    //eventRepository.findById = saber pelo id qual o evento
    //buscar o id, procura evento no banco, se não existir lança exception, se existir altera dados e salva no postgreSQL
    public Event updateEvent(Long id, CreateEventRequest request){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        //substituir os valores antigos pelos novos
        event.setName(request.getName());
        event.setLocation(request.getLocation());

        //vai salvar e atualizar em cima do event existente
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {

        //eventRepository.findById(id) = procurar o evento no PostgreSQL
        Event event = eventRepository.findById(id)
                //caso não encontre lança exception
                .orElseThrow(() -> new EventNotFoundException(id));
        //se encontrar vai deletar
        eventRepository.delete(event);
    }
}
