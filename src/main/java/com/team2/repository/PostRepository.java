package com.team2.repository;

import com.team2.domain.post.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private final List<Post> postList = new ArrayList<>();
    int lastId = 0;

    public Post findById(int id) {
        return postList.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    return null;
                });
    }

    public Post save(Post post) {
        LocalDateTime now = LocalDateTime.now();
        if(post.isNew()) { // 생성
            post.setId(++lastId);
            post.setCreatedAt(now);
            post.setModifiedAt(now);
            postList.add(post);
        } else { // 수정
            post.setModifiedAt(now);
        }

        return post;
    }

    public List<Post> findForList(String keywordType, String keyword) {
        List<Post> posts = new ArrayList<>(this.postList);

        switch (keywordType) {
            case "title" -> posts.removeIf(post -> !post.getTitle().contains(keyword));
            case "content" -> posts.removeIf(post -> !post.getContent().contains(keyword));
            case "" -> posts.removeIf(post ->
                    !post.getTitle().contains(keyword) &&
                    !post.getContent().contains(keyword));
        }

        return posts.reversed();
    }

    public void delete(Post post) {
        postList.remove(post);
    }
}
