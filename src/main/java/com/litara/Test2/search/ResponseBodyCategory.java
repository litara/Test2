package com.litara.Test2.search;

import java.util.List;

public class ResponseBodyCategory {
	String msg;
	List<CategoryForList> result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<CategoryForList> getResult() {
		return result;
	}
	public void setResult(List<CategoryForList> result) {
		this.result = result;
	}
	
}
