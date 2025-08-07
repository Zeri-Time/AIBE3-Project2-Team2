package com.team2.service;

import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

public class PostService {
    private static PostRepository PostRepository;

    public static Post write(String title, String content) {
        Post post = new Post(title, content);
        PostRepository.save(post);
        return post;
    }


}
