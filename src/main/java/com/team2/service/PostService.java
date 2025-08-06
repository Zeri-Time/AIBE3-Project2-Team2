package com.team2.service;

import com.team2.AppContext;
import com.team2.entity.Article;
import com.team2.repository.PostRepository;

import java.util.List;
import java.util.Optional;

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

    public void update (Article article, String updateTitle, String updateContent) {
        article.setTitle(updateTitle);
        article.setContent(updateContent);
    }

    public List<Article> findForList() {
        return postRepository.getArticleList();
    }

    public Optional<Article> findById(int id) {
        return postRepository.findById(id);
    }
}
