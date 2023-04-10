package com.justhm.APIServer.controller;

import com.justhm.APIServer.model.Article;
import com.justhm.APIServer.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
