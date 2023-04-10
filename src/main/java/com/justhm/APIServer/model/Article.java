package com.justhm.APIServer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document(collection = "article")
public class Article {
    @Id
    private BigInteger id;
    private String title;
    private String content;
//    private Date lastModifier;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
//        this.lastModifier = lastModifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
//
//    public Date getLastModifier() {
//        return lastModifier;
//    }
//
//    public void setLastModifier(Date lastModifier) {
//        this.lastModifier = lastModifier;
//    }
}

