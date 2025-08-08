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

    public List<Post> findForList(String keywordType, String keyword, String sortBy) {
        List<Post> posts = new ArrayList<>(this.postList);

        switch (keywordType) {
            case "title" -> posts.removeIf(post -> !post.getTitle().contains(keyword));
            case "content" -> posts.removeIf(post -> !post.getContent().contains(keyword));
            case "" -> posts.removeIf(post ->
                    !post.getTitle().contains(keyword) &&
                    !post.getContent().contains(keyword));
            default -> {
                System.out.println("잘못된 검색 유형입니다.");
                return null;
            }
        }

        switch(sortBy) {
            case "id" -> posts.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId())); // ID 오름차순
            case "createdAt" -> posts.sort((p1, p2) -> p1.getCreatedAt().compareTo(p2.getCreatedAt())); // 작성일 오름차순
            case "modifiedAt" -> posts.sort((p1, p2) -> p1.getModifiedAt().compareTo(p2.getModifiedAt())); // 수정일 오름차순
            case "" -> posts.sort((p1, p2) -> Integer.compare(p2.getId(), p1.getId())); // 기본값: ID 내림차순
            default -> {
                System.out.println("잘못된 정렬 기준입니다.");
                return null;
            }
        }

        return posts;
    }

    public void delete(Post post) {
        postList.remove(post);
    }
}
