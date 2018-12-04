package com.example.lab9.repository;

import com.example.lab9.model.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
}