package com.team2.repository;

import com.team2.domain.post.Post;
import com.team2.standard.util.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private final List<Post> postList = new ArrayList<>();
    private int lastId;

    public void save(Post post) {
        post.setId(++lastId);
        LocalDateTime now = LocalDateTime.now();
        post.setRegDate(LocalDateTimeUtil.toString(now));
        postList.add(post);
    }
}
