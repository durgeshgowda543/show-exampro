package com.example.MongoPost.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoPost.Model.People;

public interface Ruppu extends MongoRepository<People, Integer>{

}
