package com.spring.simplespringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    @GetMapping
    public String getAllArticles(){
        return "get All articles";
    }

    @PostMapping
    public String createArticle(){
        return "create article";
    }
}
