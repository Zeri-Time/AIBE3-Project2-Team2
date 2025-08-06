package com.team2.repository;

import com.team2.domain.post.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private final List<Post> posts;
    private int lastPostId;

    public PostRepository() {
        this.posts = new ArrayList<>();
        this.lastPostId = 0;
    }

    public void save(Post newPost) {
        lastPostId++;
        newPost.id = lastPostId;
        posts.add(newPost);
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findById(int id) {
        for (Post post : posts) {
            if (post.id == id) {
                return post;
            }
        }
        return null;
    }

    public void delete(Post post) {
        posts.remove(post);
    }
}
