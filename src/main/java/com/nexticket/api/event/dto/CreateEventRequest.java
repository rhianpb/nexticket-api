package com.nexticket.api.event.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class CreateEventRequest {

    @NotBlank(message = "O nome do evento é obrigatório")
    private String name;

    @NotBlank(message = "A localização do evento é obrigatória")
    private String location;

    //@NotNull = o cliente é obrigado a informar a data
    @NotNull(message = "A data do evento é obrigatória")
    //@Future a data precisa estar no futuro
    @Future(message = "A data do evento deve estar no futuro")
    private LocalDateTime eventDate;

    @NotNull(message = "A capacidade do evento é obrigatória")
    //@Positive = obriga a capacidade > 0
    @Positive(message = "A capacidade deve ser maior que zero")
    private Integer capacity;

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
}
