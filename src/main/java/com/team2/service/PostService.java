package com.team2.service;

import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void register(Post newPost) {
        postRepository.save(newPost);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }
}
