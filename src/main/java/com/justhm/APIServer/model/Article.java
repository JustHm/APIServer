package com.justhm.APIServer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "article")
@Getter
public class Article {
    @Id
    private String id;
    private String title;
    private String content;
//    private Date lastModifier;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
//        this.lastModifier = lastModifier; , Date lastModifier
    }
}

