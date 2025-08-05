package com.team2.service;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService() {
        postRepository = AppContext.postRepository;
    }

    public void write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
    }

    public List<Post> list() {
        List<Post> posts = postRepository.getPosts();
        posts.sort((a, b) -> b.getRegDate().compareTo(a.getRegDate()));
        return posts;
    }

    public Post detail(int id) {
        return postRepository.findById(id);
    }

    public void update(int id, String title, String content) {
        Post post = postRepository.findById(id);
        post.setTitle(title);
        post.setContent(content);
    }

    public void delete(Post post) {
        postRepository.remove(post);
    }
}
