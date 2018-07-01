package com.litara.Test2.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="timetable")
public class Timetable {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="way_id")
	private Way way;
	private Date date;
	@OneToMany(mappedBy="start", cascade=CascadeType.ALL)
	private Set<Ticket> ticketStart;
	@OneToMany(mappedBy="stop", cascade=CascadeType.ALL)
	private Set<Ticket> ticketStop;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Way getWay() {
		return way;
	}
	public void setWay(Way way) {
		this.way = way;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Ticket> getTicketStart() {
		return ticketStart;
	}
	public void setTicketStart(Set<Ticket> ticketStart) {
		this.ticketStart = ticketStart;
	}
	public Set<Ticket> getTicketStop() {
		return ticketStop;
	}
	public void setTicketStop(Set<Ticket> ticketStop) {
		this.ticketStop = ticketStop;
	}
}
