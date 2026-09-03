package com.nexticket.api.event.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    public Event(){
    }

    public Event(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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
}
