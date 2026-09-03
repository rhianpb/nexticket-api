package com.nexticket.api.event.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateEventRequest {

    @NotBlank(message = "O nome do evento é obrigatório")
    private String name;

    @NotBlank(message = "A localização do evento é obrigatória")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
