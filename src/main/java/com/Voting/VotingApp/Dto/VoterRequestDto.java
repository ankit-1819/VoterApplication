package com.Voting.VotingApp.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VoterRequestDto {

	

	@Positive(message = "Age should be in the positive")
	private int age;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Required field!!!")
	private String religion;

	

	public int getAge() {
		return age;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getReligion() {
		return religion;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}


}
