package com.team2.repository;

import com.team2.domain.post.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private final List<Post>  postList = new ArrayList<>();
    private int lastId = 0;
    public void save(Post post) {
        post.setId(++lastId);
        post.setCreateDate(LocalDateTime.now());
        postList.add(post);
    }

    public List<Post> getPostList() {
        return postList;
    }
}
