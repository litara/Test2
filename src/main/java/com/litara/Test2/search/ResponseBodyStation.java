package com.litara.Test2.search;

import java.util.List;


public class ResponseBodyStation {
	String msg;
	List<StationForList> result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<StationForList> getResult() {
		return result;
	}
	public void setResult(List<StationForList> result) {
		this.result = result;
	}
	
}
