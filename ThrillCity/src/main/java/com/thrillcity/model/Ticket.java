package com.thrillcity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	
	private Double balance = 200.0;
	
	private LocalDateTime dateTime = LocalDateTime.now();
	
	
	// Getters and Setters

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Integer ticketId, Double balance, LocalDateTime dateTime) {
		super();
		this.ticketId = ticketId;
		this.balance = balance;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", balance=" + balance + ", dateTime=" + dateTime + "]";
	}
	
	
	
}
