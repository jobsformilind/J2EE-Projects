package com.test.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.voting.domain.Motion;

@Repository
public interface MotionJpaRepository extends JpaRepository<Motion, Long> {

	Motion findByName(String name);

}
