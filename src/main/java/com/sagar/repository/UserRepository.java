package com.sagar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sagar.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

}
