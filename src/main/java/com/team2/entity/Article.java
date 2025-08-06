package com.team2.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Article {
    private int id;
    private String title;
    private String content;
    private String createTime;
    public Article(String content, String title) {
        this.content = content;
        this.title = title;
        this.createTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}