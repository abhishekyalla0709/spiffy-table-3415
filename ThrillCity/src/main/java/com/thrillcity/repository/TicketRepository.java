package com.thrillcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thrillcity.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
