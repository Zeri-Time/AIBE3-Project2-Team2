package com.team2.controller;

import com.team2.AppContext;
import com.team2.entity.Article;
import com.team2.service.PostService;

import java.util.Optional;
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

    public void listArticles() {
        System.out.println("번호 | 제목      | 등록일");
        System.out.println("-------------------------");
        for(Article article : postService.findForList()) {
            System.out.printf("%d   | %s | %s%n", article.getId(), article.getTitle(), article.getCreateTime());
        }
    }

    public void showDetail(int id) {
        Optional<Article> opArticle = postService.findById(id);
        if(opArticle.isEmpty()) {
            System.out.printf("%d번 게시글은 존재하지 않습니다.%n", id);
            return;
        }
        Article article = opArticle.get();
        System.out.printf("번호: %d%n제목: %s%n내용: %s%n등록일: %s%n",
                article.getId(), article.getTitle(), article.getContent(), article.getCreateTime());
    }

    public void updateArticle(int id) {
        Optional<Article> opArticle = postService.findById(id);
        if(opArticle.isEmpty()) {
            System.out.printf("%d번 게시글은 존재하지 않습니다.%n", id);
            return;
        }
        Article article = opArticle.get();
        System.out.printf("제목 (현재: %s):", article.getTitle());
        String updateTitle = scanner.nextLine();
        System.out.printf("내용 (현재: %s):", article.getContent());
        String updateContent = scanner.nextLine();
        System.out.printf("%d번 게시글이 수정되었습니다%n.", article.getId());
        postService.update(article, updateTitle, updateContent);
    }
}
