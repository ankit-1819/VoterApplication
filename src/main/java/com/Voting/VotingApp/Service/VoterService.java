package com.Voting.VotingApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Voting.VotingApp.Entity.Voter;
import com.Voting.VotingApp.Exception.IdNotFoundException;
import com.Voting.VotingApp.Exception.VoterAgeException;
import com.Voting.VotingApp.Repository.VoterRepository;

@Service
public class VoterService {

	private final VoterRepository voterRepository;

	public VoterService(VoterRepository voterRepository) {
		super();
		this.voterRepository = voterRepository;
	}

	public Voter addVoter(Voter voter) {

		if (voter.getAge() < 18) {

			throw new VoterAgeException("Age criteria not matching!!!");
		}

		Voter savedVoter = voterRepository.save(voter);
		return savedVoter;
	}

	public List<Voter> getVoter() {

		List<Voter> allVoter = voterRepository.findAll();

		return allVoter;
	}

	public Voter getVoterById(long id) {

		Optional<Voter> existingVoter = voterRepository.findById(id);

		if (existingVoter.isEmpty()) {

			throw new IdNotFoundException("Id is not valid..");
		}

		Voter voter = existingVoter.get();

		return voter;
	}

	public Voter updateVoter(long id, Voter voter) {

		Optional<Voter> existingVoter = voterRepository.findById(id);

		if (existingVoter.isEmpty()) {

			throw new IdNotFoundException("Id is not valid..");
		}

		Voter savedVoter = existingVoter.get();
		
		if (voter.getAge() < 18) {
			
			throw new VoterAgeException("Age criteria is not matching!!!");
		}

		savedVoter.setName(voter.getName());
		savedVoter.setAge(voter.getAge());
		savedVoter.setAddress(voter.getAddress());
		savedVoter.setReligion(voter.getReligion());

		return voterRepository.save(savedVoter);

	}

	public String deleteVoter(long id) {

		Optional<Voter> existingVoter = voterRepository.findById(id);

		if (existingVoter.isEmpty()) {

			throw new IdNotFoundException("Id is not valid..");
		}

		Voter voter = existingVoter.get();
		
		voterRepository.deleteById(voter.getId());
		
		return "Voter successfully deleted!!!";

	}
}
