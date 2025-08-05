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
        Post post = new Post(title, content);
        post = postRepository.save(post);
        return post;
    }

    public List<Post> findForList() {
        return postRepository.findForList();
    }

    public Post findPostById(int id) {
        Post post = postRepository.findById(id);

        if (post == null) {
            return null;
        }

        return post;
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
    }
}
