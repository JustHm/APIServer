package com.justhm.APIServer.controller;

import com.justhm.APIServer.model.Article;
import com.justhm.APIServer.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> articleList(@RequestParam int page, @RequestParam int num) {
        return articleRepository.findAllWithoutContent();
    }
    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable("id") String id) {
        Optional<Article> article = articleRepository.findById(id);
        return article;
    }

    @PostMapping("/article")
    public Boolean articleSave(@RequestBody Article article) {
        if (article.getTitle().equals("") || article.getContent().equals("")) {
            return false;
        }
        articleRepository.save(article);
        return true;
    }
    @DeleteMapping("/article/del")
    public Boolean deleteArticle(@RequestParam String id) {
        articleRepository.deleteById(id);
        return true;
    }
    @PostMapping("article/{id}/edit")
    public Boolean editArticle(@PathVariable("id") String id, @RequestBody Article editArticle) {
        Article article = articleRepository.findById(id).get();
        article.setTitle(editArticle.getTitle());
        article.setContent(editArticle.getContent());
        articleRepository.save(article);
        return true;
    }
}
