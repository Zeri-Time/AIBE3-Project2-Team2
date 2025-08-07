package com.team2.service;

import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;

import java.util.List;

public class PostService {
    private static PostRepository postRepository = new PostRepository();

    public static Post write(String title, String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
        return post;
    }

    public static List<Post> getPostList() {
        List<Post> postList = postRepository.getPostList();
        return postList;
    }

    public static Post findById(int id) {
        return PostRepository.findById(id);
    }

    public static void modify(Post post, String newTitle, String newContent) {
        post.setTitle(newTitle);
        post.setContent(newContent);
        postRepository.update(post);
    }
}
