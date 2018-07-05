package com.litara.Test2.search;

import java.util.List;

import com.litara.Test2.model.Train;

public class ResponseBodyTrain {
	String msg;
	List<TrainForList> result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<TrainForList> getResult() {
		return result;
	}
	public void setResult(List<TrainForList> result) {
		this.result = result;
	}
	
}
