package com.litara.Test2.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.litara.Test2.model.Train;

public class TrainForList {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	private String date_start;
	private String date_stop;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_stop() {
		return date_stop;
	}
	public void setDate_stop(String date_stop) {
		this.date_stop = date_stop;
	}

}
