package com.test.spring.security.scaffold.service;

import java.util.List;

import com.test.spring.security.scaffold.model.Activity;

public interface ExerciseService {

	List<Activity> findAllActivities();

}