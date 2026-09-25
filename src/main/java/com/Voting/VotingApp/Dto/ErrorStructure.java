package com.Voting.VotingApp.Dto;

import java.util.Map;

public class ErrorStructure {

	private int status;
	private String message;
	private Map<String, String> error;
	
	public ErrorStructure() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ErrorStructure(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}


	public ErrorStructure(int status, String message, Map<String, String> error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}
	
	
}
