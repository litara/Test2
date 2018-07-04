package com.litara.Test2.search;

import java.util.List;

import com.litara.Test2.model.Passenger;

public class ResponseBodyPassenger {
	String msg;
	List<Passenger> result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Passenger> getResult() {
		return result;
	}
	public void setResult(List<Passenger> result) {
		this.result = result;
	}
	
}
