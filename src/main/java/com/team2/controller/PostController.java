package com.team2.controller;

import com.team2.AppContext;
import com.team2.domain.post.Post;
import com.team2.service.PostService;
import com.team2.standard.util.LocalDateTimeUtil;

import java.util.List;
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

    public void actionList() {
        List<Post> posts = postService.list();
        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        for (Post post : posts) {
            System.out.printf("%d  | %s      | %s\n", post.getId(), post.getTitle(), LocalDateTimeUtil.toString(post.getRegDate()));
        }
    }

    public void actionDetail(int id) {
        if (id == -1) {
            System.out.println("번호를 다시 입력 해 주세요.");
            return;
        }
        Post post = postService.detail(id);
        if (post == null) {
            System.out.printf("%d번 게시글은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.println("번호: " + post.getId());
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: " + post.getContent());
        System.out.println("등록일: " + LocalDateTimeUtil.toString(post.getRegDate()));
    }
}
