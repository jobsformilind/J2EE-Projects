package com.test.voting.test;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.voting.domain.Motion;
import com.test.voting.service.MotionService;
import com.test.voting.utils.MotionStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context-test.xml" })
public class TestMotion {
	@Autowired
	private MotionService service;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	@Transactional
	@Rollback(true)
	public void testMotionCRUD() {
		Motion entity = new Motion();
		entity.setName("Motion 1");
		entity.setDescription("Dummy motion created.");
		entity.setMaxAllowedVotes(50);
		entity.setStatus(MotionStatus.NEW.ordinal());
		Serializable obj = service.add(entity);
		Assert.assertNotNull("1. TestMotion.testMotionCRUD: Entity must be saved.", obj);
		System.out.println("Insert inserted : " + obj);

		Motion foundOne = service.findById(obj);
		Assert.assertNotNull("2. TestMotion.testMotionCRUD: Database entity must not be null.", foundOne);
		System.out.println("Record found : " + obj);

		foundOne.setName("Motion 2");
		foundOne.setDescription("Motion 2 created.");
		foundOne.setMaxAllowedVotes(100);
		service.update(foundOne);
		System.out.println("Record Updated : " + obj);

		Motion againFoundOne = service.findById(obj);
		Assert.assertNotNull("3. TestMotion.testMotionCRUD: Database entity must not be null.", againFoundOne);
		Assert.assertEquals("4. TestMotion.testMotionCRUD: After update, name should be updated in database.", againFoundOne.getName(), foundOne.getName());
		System.out.println("Record again found : " + obj);

		thrown.expect(ObjectNotFoundException.class);
		service.delete(againFoundOne);
		Motion deletedOne = service.findById(obj);
		Assert.assertNull("3. TestMotion.testMotionCRUD: Entity is deleted.", deletedOne);
		System.out.println("Record deleted : " + obj);
	}
}
