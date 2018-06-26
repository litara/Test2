package com.litara.Test2.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="station")
public class Station {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	private String name;
	private String country;
	private String region;
	@OneToMany(mappedBy="station", cascade=CascadeType.ALL)
	private Set<Way> setWay;
	@OneToMany(mappedBy="stationOrder", cascade=CascadeType.ALL)
	private Set<Coach> setCoach;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Set<Way> getSetWay() {
		return setWay;
	}
	public void setSetWay(Set<Way> setWay) {
		this.setWay = setWay;
	}
	public Set<Coach> getSetCoach() {
		return setCoach;
	}
	public void setSetCoach(Set<Coach> setCoach) {
		this.setCoach = setCoach;
	}
	
}
