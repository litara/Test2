package com.litara.Test2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litara.Test2.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
