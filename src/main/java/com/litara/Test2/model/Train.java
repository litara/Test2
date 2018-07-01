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
@Table(name = "train")
public class Train {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	private String name;
	private Date date_start;
	private Date date_stop;
	@OneToMany(mappedBy="train", cascade=CascadeType.ALL)
	private Set<Way> setWay;
	@OneToMany(mappedBy="trainConsist", cascade=CascadeType.ALL)
	private Set<Consist> setConsist;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_stop() {
		return date_stop;
	}
	public void setDate_stop(Date date_stop) {
		this.date_stop = date_stop;
	}
	public Set<Way> getSetWay() {
		return setWay;
	}
	public void setSetWay(Set<Way> setWay) {
		this.setWay = setWay;
	}
	
}
