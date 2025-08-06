package com.team2.repository;

import com.team2.entity.Article;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Getter
@Setter
public class PostRepository {
    private final List<Article> articleList = new ArrayList<>();
    private int lastId = 0;

    public void save(Article article) {
        article.setId(++lastId);

        articleList.add(article);
    }

    public Optional<Article> findById(int id) {
        int idx = findIndexById(id);

        if(idx == -1) return Optional.empty();

        return Optional.of(articleList.get(idx));
    }

    public int findIndexById(int id) {
        return IntStream
                .range(0, articleList.size())
                .filter(i -> articleList.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}
