package com.litara.Test2.services;

import java.util.List;

import com.litara.Test2.model.Ticket;

public interface TicketService {
	public Ticket findById(Long id);
	public List<Ticket> outputAll();
	public void saveTicket(Ticket ticket);
	public void del(Long id);
}
