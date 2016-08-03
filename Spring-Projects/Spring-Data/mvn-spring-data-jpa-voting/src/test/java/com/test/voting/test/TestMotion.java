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
import com.test.voting.repository.MotionJpaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context-test.xml" })
public class TestMotion {
	@Autowired
	private MotionJpaRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(true)
	public void testMotionCRUD() {
		System.out.println("\nInside TestMotion CRUD");
		String name = "Motion for maned mission on Mars";
		Motion entity = new Motion(name);
		entity = repository.saveAndFlush(entity);
		entityManager.clear();

		Motion dbEntity = repository.findOne(entity.getId());
		Assert.assertNotNull(dbEntity);
		Assert.assertEquals(name, dbEntity.getName());

		repository.delete(dbEntity.getId());
	}
}
