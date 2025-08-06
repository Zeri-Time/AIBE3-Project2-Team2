package com.team2.repository;

import com.team2.domain.post.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private final List<Post> postList = new ArrayList<>();
    int lastId = 0;

    Post findById(int id) {
        return postList.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("해당 아이디는 존재하지 않습니다.");
                    return null;
                });
    }

    public Post save(Integer id, String title, String content) {
        Post post;

        if (id == null) {
            post = new Post(++lastId, title, content);
            postList.add(post);
        } else {
            post = findById(id);
            if (post == null) {
                return null;
            }
            post.setTitle(title);
            post.setContent(content);
        }

        return post;
    }
}