package com.team2.controller;

import com.team2.AppContext;
import com.team2.service.PostService;

import java.util.Scanner;

public class PostController {

    private final PostService postService;
    private final Scanner scanner;

    public PostController() {
        postService = AppContext.postService;
        scanner = AppContext.scanner;
    }


    public void actionWrite() {
        System.out.print("제목: ");
        String title = scanner.nextLine();

        System.out.print("내용: ");
        String content = scanner.nextLine();
        postService.write(title, content);

        System.out.println("=> 게시글이 등록되었습니다.");
    }
}
