package com.litara.Test2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="timetable_start")
	private Timetable start;
	@ManyToOne
	@JoinColumn(name="timetable_stop")
	private Timetable stop;
	private int cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timetable getStart() {
		return start;
	}
	public void setStart(Timetable start) {
		this.start = start;
	}
	public Timetable getStop() {
		return stop;
	}
	public void setStop(Timetable stop) {
		this.stop = stop;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Passenger getPassengerTicket() {
		return passengerTicket;
	}
	public void setPassengerTicket(Passenger passengerTicket) {
		this.passengerTicket = passengerTicket;
	}
	@ManyToOne
	@JoinColumn(name="id_passenger")
	private Passenger passengerTicket;
	
}
