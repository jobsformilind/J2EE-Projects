package com.test.voting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.voting.domain.Motion;
import com.test.voting.domain.MotionVoter;
import com.test.voting.domain.Voter;
import com.test.voting.enums.Vote;
import com.test.voting.repository.MotionJpaRepository;
import com.test.voting.repository.MotionVoterJpaRepository;
import com.test.voting.repository.VoterJpaRepository;
import com.test.voting.service.MotionVoterService;

public class MotionVoterServiceImpl implements MotionVoterService {

	@Autowired
	private MotionVoterJpaRepository mvRepository;

	@Autowired
	private MotionJpaRepository mRepository;

	@Autowired
	private VoterJpaRepository vRepository;

	public void addVote(String motionName, Long voterId, Vote vote) {
		Motion motion = mRepository.findByName(motionName);
		Voter voter = vRepository.findOne(voterId);
		MotionVoter mv = mvRepository.findByMotionAndVoter(motion, voter);
		if (mv == null) {
			mv = new MotionVoter();
			mv.setMotion(motion);
			mv.setVoter(voter);
			mv.setVote(vote);
		}
		mvRepository.saveAndFlush(mv);
	}
}
