package com.justhm.APIServer.repository;

import com.justhm.APIServer.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ArticleRepository extends MongoRepository<Article, BigInteger> {

}