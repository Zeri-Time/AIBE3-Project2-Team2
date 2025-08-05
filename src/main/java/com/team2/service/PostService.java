package com.team2.service;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = AppContext.postRepository;
    }
    public Post write(String title, String content) {
        Post post = this.postRepository.save(null, title, content);
        return post;
    }

    public List<Post> findForList() {
        return this.postRepository.findForList();
    }
}
