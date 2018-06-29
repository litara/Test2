package com.litara.Test2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="consist")
public class Consist {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="train_id")
	private Train trainConsist;
	@ManyToOne
	@JoinColumn(name="coach_id")
	private Coach coachConsist;
	private int number_in_consist;
	@ManyToOne
	@JoinColumn(name="station_id_start")
	private Station stationConsistStart;
	@ManyToOne
	@JoinColumn(name="station_id_end")
	private Station stationConsistEnd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Train getTrainConsist() {
		return trainConsist;
	}
	public void setTrainConsist(Train trainConsist) {
		this.trainConsist = trainConsist;
	}
	public Coach getCoachConsist() {
		return coachConsist;
	}
	public void setCoachConsist(Coach coachConsist) {
		this.coachConsist = coachConsist;
	}
	public int getNumber_in_consist() {
		return number_in_consist;
	}
	public void setNumber_in_consist(int number_in_consist) {
		this.number_in_consist = number_in_consist;
	}
	public Station getStationConsistStart() {
		return stationConsistStart;
	}
	public void setStationConsistStart(Station stationConsistStart) {
		this.stationConsistStart = stationConsistStart;
	}
	public Station getStationConsistEnd() {
		return stationConsistEnd;
	}
	public void setStationConsistEnd(Station stationConsistEnd) {
		this.stationConsistEnd = stationConsistEnd;
	}
}
