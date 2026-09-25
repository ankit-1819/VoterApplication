package com.Voting.VotingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Voting.VotingApp.Entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Long>  {

	
}
