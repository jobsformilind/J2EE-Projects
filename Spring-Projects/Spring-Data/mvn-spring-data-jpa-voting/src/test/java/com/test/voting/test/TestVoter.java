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

import com.test.voting.domain.Voter;
import com.test.voting.repository.VoterJpaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context-test.xml" })
public class TestVoter {

	@Autowired
	private VoterJpaRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(true)
	public void testCRUD() {
		System.out.println("\nInside TestVoter CRUD");
		String name = "Voter 1";
		Voter entity = new Voter(name);
		entity = repository.saveAndFlush(entity);
		entityManager.clear();

		Voter dbEntity = repository.findOne(entity.getId());
		Assert.assertNotNull(dbEntity);
		Assert.assertEquals(name, dbEntity.getName());

		repository.delete(dbEntity.getId());
	}

}
