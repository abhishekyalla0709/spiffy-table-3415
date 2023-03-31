package com.thrillcity.service;

import com.thrillcity.exceptions.TicketException;
import com.thrillcity.model.Ticket;

public interface TicketService {	
	
	public Ticket insertTicket(Ticket ticket);
	
	public Ticket updateTicke(Ticket ticket) throws TicketException;
	
	public Ticket deleteTicket(Ticket ticket) throws TicketException;
}
