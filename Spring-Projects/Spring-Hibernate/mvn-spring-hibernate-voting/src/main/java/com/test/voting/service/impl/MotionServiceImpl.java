package com.test.voting.service.impl;

import org.springframework.stereotype.Service;

import com.test.voting.base.hibernate.BaseHibernateServiceImpl;
import com.test.voting.domain.Motion;
import com.test.voting.service.MotionService;

@Service
public class MotionServiceImpl extends BaseHibernateServiceImpl<Motion>implements MotionService {

}
