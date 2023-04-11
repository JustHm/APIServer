package com.justhm.APIServer.controller;

import com.justhm.APIServer.model.Article;
import com.justhm.APIServer.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
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
        return list;
    }

    @GetMapping("/article")
    public Optional<Article> getArticle(@RequestParam BigInteger id) {
        return articleRepository.findById(id);
    }
    @DeleteMapping("/article/del")
    public Boolean deleteArticle(@RequestParam BigInteger id) {
        articleRepository.deleteById(id);
        return true;
    }
}
