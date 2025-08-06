package com.team2.repository;

import com.team2.entity.Article;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostRepository {
    private final List<Article> articleList = new ArrayList<>();
    private int lastId = 0;

    public void save(Article article) {
        article.setId(++lastId);

        articleList.add(article);
    }
}
