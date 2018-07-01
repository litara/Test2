package com.litara.Test2.model;

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
	@OneToMany(mappedBy="coachConsist", cascade=CascadeType.ALL)
	private Set<Consist> setConsist;
	@OneToMany(mappedBy="coachPlace", cascade=CascadeType.ALL)
	private Set<Place> setPlace;
	public Set<Consist> getSetConsist() {
		return setConsist;
	}
	public void setSetConsist(Set<Consist> setConsist) {
		this.setConsist = setConsist;
	}
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
	public String getTypeCategoryClass() {
		return type.getName()+"|"+category.getName()+"|"+classCoach.getName();
	}
	public Set<Place> getSetPlace() {
		return setPlace;
	}
	public void setSetPlace(Set<Place> setPlace) {
		this.setPlace = setPlace;
	}
	
}
