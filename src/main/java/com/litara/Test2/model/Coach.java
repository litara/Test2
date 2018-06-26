package com.litara.Test2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="coach")
public class Coach {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="type_coach_id")
	private Type type;
	@ManyToOne
	@JoinColumn(name="category_coach_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="class_coach_id")
	private Class classCoach;
	@ManyToOne
	@JoinColumn(name="station_id")
	private Station stationOrder;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Class getClassCoach() {
		return classCoach;
	}
	public void setClassCoach(Class classCoach) {
		this.classCoach = classCoach;
	}
	public Station getStationOrder() {
		return stationOrder;
	}
	public void setStationOrder(Station stationOrder) {
		this.stationOrder = stationOrder;
	}
	
}
