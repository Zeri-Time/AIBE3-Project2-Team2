package com.team2.controller;

import com.team2.AppContext;
import com.team2.entity.Article;
import com.team2.service.PostService;

import java.util.Scanner;

public class PostController {
    private final Scanner scanner;
    private final PostService postService;

    public PostController() {
        this.scanner = AppContext.scanner;
        this.postService = AppContext.postService;
    }

    public void writeArticle() {
        System.out.print("제목: ");
        String title = scanner.nextLine();

        System.out.print("내용: ");
        String content = scanner.nextLine();

        Article article = postService.write(title, content);
        System.out.printf("=> %s번 게시글이 등록되었습니다.%n", article.getId());
    }

}
