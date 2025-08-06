package com.team2.controller;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.service.PostService;

import java.util.Scanner;

public class PostController {
    private final Scanner scanner;
    private final PostService postService;

    public PostController() {
        scanner = AppContext.scanner;
        postService = AppContext.postService;
    }
    public void actionWrite() {
        System.out.print("제목 : ");
        String title = scanner.nextLine().trim();

        System.out.print("내용 : ");
        String content = scanner.nextLine().trim();

        Post post = postService.write(title, content);
        System.out.printf("%d번 게시글이 등록되었습니다.%n", post.getId());
    }
}