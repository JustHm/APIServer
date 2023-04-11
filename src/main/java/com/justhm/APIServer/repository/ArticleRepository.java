package com.justhm.APIServer.repository;

import com.justhm.APIServer.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    @Query(value = "{}", fields = "{'content' : 0}")
    List<Article> findAllWithoutContent();

//    @Query(value = "{'id': 0}")
//    Article updateArticle(String id);
}