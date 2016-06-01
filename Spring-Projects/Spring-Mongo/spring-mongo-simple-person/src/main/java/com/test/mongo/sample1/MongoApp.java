package com.test.mongo.sample1;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

public class MongoApp {
	public static void main(String[] args) throws Exception {
		MongoClient mongoClient = new MongoClient();
		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(mongoClient, "test"));
		mongoOps.insert(new Person("Joe", 34));
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is("Joe"));
		System.out.println("*** : " + mongoOps.findOne(query, Person.class));
	}
}
