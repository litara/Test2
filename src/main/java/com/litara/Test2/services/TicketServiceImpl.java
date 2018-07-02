package com.litara.Test2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litara.Test2.model.Ticket;
import com.litara.Test2.repos.TicketRepository;

@Service("ticketService")
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket findById(Long id) {
		return ticketRepository.getOne(id);
	}

	@Override
	public List<Ticket> outputAll() {
		return ticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void del(Long id) {
		ticketRepository.deleteById(id);
	}
	
}
