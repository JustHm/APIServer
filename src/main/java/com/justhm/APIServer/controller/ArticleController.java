package com.justhm.APIServer.controller;

import com.justhm.APIServer.model.Article;
import com.justhm.APIServer.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("api")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/article")
    public Boolean articleSave(@RequestBody Article article) {
        articleRepository.save(article);
        return true;
    }

    @GetMapping("/articles")
    public List<Article> articleList(@RequestParam int page, @RequestParam int num) {
        List<Article> list = articleRepository.findAll();
//        if (list.isEmpty()) {
//            return null;
//        }
        return list;
    }

    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable("id") String id) {
        Optional<Article> article = articleRepository.findById(id);
        return article;
    }
    @DeleteMapping("/article/del")
    public Boolean deleteArticle(@RequestParam String id) {
        articleRepository.deleteById(id);
        return true;
    }
}
