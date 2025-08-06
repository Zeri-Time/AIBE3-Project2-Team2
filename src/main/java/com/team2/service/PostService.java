package com.team2.service;

import com.team2.AppContext;
import com.team2.entity.Article;
import com.team2.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = AppContext.postRepository;
    }

    public Article write (String title, String content) {
        Article article = new Article(title, content);
        postRepository.save(article);

        return article;
    }
}
