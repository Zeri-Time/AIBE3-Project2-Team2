package com.team2.controller;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.service.PostService;

import java.util.Scanner;

public class PostController {
    private final Scanner sc;
    private final PostService postService;

    public PostController() {
        this.sc = AppContext.sc;
        this.postService = AppContext.postService;
    }
    public void actionWrite() {
        System.out.print("제목: ");
        String title = sc.nextLine().trim();

        System.out.print("내용: ");
        String content = sc.nextLine().trim();

        Post post = postService.write(title, content);
        System.out.println("%d번 게시물이 등록되었습니다.".formatted(post.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 제목 / 내용 / 작성일 / 수정일");
        System.out.println("----------------------------");

        for (Post post : postService.findForList()) {
            System.out.printf("%d / %s / %s / %s\n",
                    post.getId(),
                    post.getTitle(),
                    post.getCreatedAt().format(post.getFormatter()),
                    post.getModifiedAt().format(post.getFormatter()));
        }
    }
}
