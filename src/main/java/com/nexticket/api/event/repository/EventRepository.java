package com.nexticket.api.event.repository;

import com.nexticket.api.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//EventRepository = camada que conversa com o banco
public interface EventRepository extends JpaRepository<Event, Long> {

}
