package com.nexticket.api.event.entity;

import com.nexticket.api.event.enums.EventStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

//classe representa uma entidade persistida no banco
@Entity
//Diz que corresponde a tabela events
@Table(name = "events")
//Event = entidade que representa os dados
public class Event {

    //chave primária
    @Id
    //vai ser gerado automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @Column(nullable = false)
    private Integer capacity;

    //@Enumerated(EnumType.String) = faz o banco anotar o enum que é do tipo string
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;

    public Event(){
    }

    public Event(Long id, String name, String location, LocalDateTime eventDate, Integer capacity, EventStatus status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.eventDate = eventDate;
        this.capacity = capacity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
