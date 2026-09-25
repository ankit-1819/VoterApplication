package com.Voting.VotingApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Voting.VotingApp.Dto.VoterRequestDto;
import com.Voting.VotingApp.Dto.VoterResponseDto;
import com.Voting.VotingApp.Entity.Voter;
import com.Voting.VotingApp.Mapper.VoterMapper;
import com.Voting.VotingApp.Service.VoterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/voter")
public class VoterController {

	private final VoterService voterService;
	private final VoterMapper voterMapper;
	
	public VoterController(VoterService voterService, VoterMapper voterMapper) {
		super();
		this.voterService = voterService;
		this.voterMapper = voterMapper;
	}
	
	@PostMapping
	public VoterResponseDto addvoter(@Valid @RequestBody VoterRequestDto dto) {
		
		Voter voter = voterMapper.toEntity(dto);
		
		Voter savedVoter = voterService.addVoter(voter);
		
		return voterMapper.toDto(savedVoter);
	}
	
	@GetMapping
	public List<VoterResponseDto> allVoter(){
		
		List<Voter> voter = voterService.getVoter();
		
		List<VoterResponseDto> allVoter = new ArrayList<VoterResponseDto>();
		
		for (Voter voters : voter) {
			
			VoterResponseDto dto = voterMapper.toDto(voters);
			allVoter.add(dto);
		}
		
		return allVoter;
	}
	
	@GetMapping("/{id}")
	public VoterResponseDto getVoterById(@PathVariable long id) {
		
		Voter voter = voterService.getVoterById(id);
		
		return voterMapper.toDto(voter);
	}
	
	@PutMapping("/{id}")
	public VoterResponseDto updateVoter(@PathVariable long id,@Valid @RequestBody VoterRequestDto dto) {
		
		Voter voter = voterMapper.toEntity(dto);
		
		Voter savedVoter = voterService.updateVoter(id, voter);
		
		return voterMapper.toDto(savedVoter);
	}
	
	@DeleteMapping("/{id}")
	public String deleteVoter(@PathVariable long id) {
		
		return voterService.deleteVoter(id);
	}
	
}
