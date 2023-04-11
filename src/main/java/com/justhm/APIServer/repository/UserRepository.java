package com.justhm.APIServer.repository;

import com.justhm.APIServer.model.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<LoginRequest, String> {
    @Query("{ 'username' : ?0 }")
    Optional<LoginRequest> findByUsername(String username);
}
