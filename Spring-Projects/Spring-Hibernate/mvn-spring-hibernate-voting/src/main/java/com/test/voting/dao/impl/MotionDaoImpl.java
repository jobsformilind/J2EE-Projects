package com.test.voting.dao.impl;

import org.springframework.stereotype.Repository;

import com.test.voting.base.hibernate.BaseHibernateDaoImpl;
import com.test.voting.dao.MotionDao;
import com.test.voting.domain.Motion;

@Repository
public class MotionDaoImpl extends BaseHibernateDaoImpl<Motion>implements MotionDao {

}
