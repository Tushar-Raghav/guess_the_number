package com.firstproject.first_demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameSessionRepository extends MongoRepository<GameSessionDocument,String> {

    
} 