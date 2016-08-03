package com.test.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.voting.domain.Motion;
import com.test.voting.domain.MotionVoter;
import com.test.voting.domain.Voter;

@Repository
public interface MotionVoterJpaRepository extends JpaRepository<MotionVoter, Long> {

	MotionVoter findByMotionAndVoter(Motion motion, Voter voter);

}
