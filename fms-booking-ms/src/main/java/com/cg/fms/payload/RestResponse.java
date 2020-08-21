package com.cg.fms.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RestResponse<T> {

	private boolean status;
	private String message;
	private T data;

	public RestResponse() {
		super();
	}

	public RestResponse(boolean status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public RestResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
}