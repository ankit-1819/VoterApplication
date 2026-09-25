package com.Voting.VotingApp.Mapper;

import org.springframework.stereotype.Component;

import com.Voting.VotingApp.Dto.VoterRequestDto;
import com.Voting.VotingApp.Dto.VoterResponseDto;
import com.Voting.VotingApp.Entity.Voter;

@Component
public class VoterMapper {

	public Voter toEntity(VoterRequestDto dto) {
		
		Voter voter = new Voter();
		
		voter.setName(dto.getName());
		voter.setAge(dto.getAge());
		voter.setAddress(dto.getAddress());
		voter.setReligion(dto.getReligion());
		
		return voter;
	}
	
	public VoterResponseDto toDto(Voter voter) {
		
		VoterResponseDto dto = new VoterResponseDto();
		
		dto.setId(voter.getId());
		dto.setAge(voter.getAge());
		dto.setName(voter.getName());
		dto.setAddress(voter.getAddress());
		
		return dto;
	}
}
