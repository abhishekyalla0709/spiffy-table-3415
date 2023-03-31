package com.thrillcity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thrillcity.exceptions.TicketException;
import com.thrillcity.model.Ticket;
import com.thrillcity.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Ticket insertTicket(Ticket ticket) {
		return null;
		
	}

	@Override
	public Ticket updateTicke(Ticket ticket) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket deleteTicket(Ticket ticket) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

}
