package com.team2.service;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = AppContext.postRepository;
    }

    public void write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
    }
}
