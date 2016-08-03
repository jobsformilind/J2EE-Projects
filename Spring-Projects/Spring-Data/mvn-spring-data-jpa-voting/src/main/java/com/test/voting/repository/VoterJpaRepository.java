package com.test.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.voting.domain.Voter;

@Repository
public interface VoterJpaRepository extends JpaRepository<Voter, Long> {

}
