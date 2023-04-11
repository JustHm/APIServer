package com.justhm.APIServer.repository;

import com.justhm.APIServer.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

}