package com.employee.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.demo.model.EModel;

public interface ERepo extends MongoRepository<EModel, Integer> {

}
