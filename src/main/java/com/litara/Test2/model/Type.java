package com.litara.Test2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="type_coach")
public class Type {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	private String name;
	@OneToMany(mappedBy="type", cascade=CascadeType.ALL)
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
	public Set<Coach> getSetCoach() {
		return setCoach;
	}
	public void setSetCoach(Set<Coach> setCoach) {
		this.setCoach = setCoach;
	}
	
}
