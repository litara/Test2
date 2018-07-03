package com.litara.Test2.model;

import java.sql.Time;
import java.util.Comparator;
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
@Table(name="way")
public class Way {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="station_id")
	private Station station;
	@ManyToOne
	@JoinColumn(name="train_id")
	private Train train;
	private Time start_time;
	private Time end_time;
	@OneToMany(mappedBy="way", cascade=CascadeType.ALL)
	private Set<Timetable> timetable;
	public static Comparator<Way> COMPARE_BY_START_TIME = new Comparator<Way>() {
        public int compare(Way one, Way other) {
            return one.start_time.compareTo(other.start_time);
        }
    };
	public Set<Timetable> getTimetable() {
		return timetable;
	}
	public void setTimetable(Set<Timetable> timetable) {
		this.timetable = timetable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	public String getStationTrain() {
		return station.getName()+":"+train.getName();
	}
	
}
