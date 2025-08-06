package com.team2.service;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = AppContext.postRepository;
    }
    public Post write(String title, String content) {
        Post post = this.postRepository.save(null, title, content);
        return post;
    }
}