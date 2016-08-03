package com.test.voting.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.voting.domain.Motion;
import com.test.voting.domain.MotionVoter;
import com.test.voting.domain.Voter;
import com.test.voting.enums.Vote;
import com.test.voting.repository.MotionJpaRepository;
import com.test.voting.repository.MotionVoterJpaRepository;
import com.test.voting.repository.VoterJpaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context-test.xml" })
public class TestMotionVoter {

	@Test
	@Transactional
	@Rollback(true)
	public void testCRUD() {
		System.out.println("\nInside TestMotionVoter CRUD");
		Motion motion = mRepository.saveAndFlush(new Motion("Motion1"));
		Voter voter = vRepository.saveAndFlush(new Voter("Voter1"));
		entityManager.clear();

		MotionVoter mv = new MotionVoter();
		mv.setMotion(motion);
		mv.setVoter(voter);
		mv.setVote(Vote.YES);
		mv = mvrepository.saveAndFlush(mv);
		entityManager.clear();
		Assert.assertNotNull(mv);
		System.out.println("Motion Voter : " + mv);
		
		mvrepository.delete(mv.getId());
		vRepository.delete(voter.getId());
		mRepository.delete(motion.getId());
	}

	@Autowired
	private MotionVoterJpaRepository mvrepository;

	@Autowired
	private MotionJpaRepository mRepository;

	@Autowired
	private VoterJpaRepository vRepository;

	@PersistenceContext
	private EntityManager entityManager;
}
