package com.team2.controller;

import com.team2.Rq;
import com.team2.domain.post.Post;
import com.team2.service.PostService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PostController {
    private final Scanner sc;
    private final PostService postService;

    public PostController(PostService postService) {
        this.sc = new Scanner(System.in);
        this.postService = postService;
    }

    public void write() {
        System.out.println("제목: ");
        String title = sc.nextLine();
        System.out.println("내용: ");
        String content = sc.nextLine();
        String regDate = LocalDate.now().toString();

        Post newPost = new Post(0, title, content, regDate);
        postService.register(newPost);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", newPost.id);
    }

    public void list() {
        List<Post> posts = postService.getPosts();

        if (posts.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("--게시글 목록--");
        System.out.println("번호 / 제목 / 등록일");
        for (int i = posts.size() - 1; i >= 0; i--) {
            Post post = posts.get(i);
            System.out.printf("%d / %s / %s\n", post.id, post.title, post.regDate);
        }
    }

    public void detail(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요. (예: detail?id=1)");
            return;
        }

        Post foundPost = postService.getPostById(id);

        if (foundPost != null) {
            System.out.println("--- 게시글 상세 ---");
            System.out.println("번호: " + foundPost.id);
            System.out.println("제목: " + foundPost.title);
            System.out.println("내용: " + foundPost.content);
            System.out.println("등록일: " + foundPost.regDate);
        } else {
            System.out.printf("%d번 게시글은 존재하지 않습니다.\n", id);
        }
    }

    public void delete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요. (예: delete?id=1)");
            return;
        }

        Post foundPost = postService.getPostById(id);

        if (foundPost == null) {
            System.out.printf("%d번 게시글은 존재하지 않습니다.\n", id);
            return;
        }

        postService.deletePost(foundPost);
        System.out.printf("%d번 게시글이 삭제되었습니다.\n", id);
    }

    public void update(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요. (예: update?id=1)");
            return;
        }

        Post foundPost = postService.getPostById(id);

        if (foundPost == null) {
            System.out.printf("%d번 게시글은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 제목: %s\n", foundPost.title);
        System.out.print("새 제목: ");
        String newTitle = sc.nextLine();

        System.out.printf("기존 내용: %s\n", foundPost.content);
        System.out.print("새 내용: ");
        String newContent = sc.nextLine();

        foundPost.title = newTitle;
        foundPost.content = newContent;

        System.out.printf("%d번 게시글이 수정되었습니다.\n", id);
    }
}
