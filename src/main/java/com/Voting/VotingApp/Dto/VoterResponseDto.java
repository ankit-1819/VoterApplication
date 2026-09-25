package com.Voting.VotingApp.Dto;

public class VoterResponseDto {

		private long id;
		private int age;
		private String name;
		private String address;

		public int getAge() {
			return age;
		}
		public String getName() {
			return name;
		}
		public String getAddress() {
			return address;
		}
		public void setId(long id) {
			this.id = id;
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
		public long getId() {
			return id;
		}


}
