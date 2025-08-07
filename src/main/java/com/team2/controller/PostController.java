package com.team2.controller;

import com.team2.domain.post.Post;
import com.team2.service.PostService;

import java.util.Scanner;

public class PostController {
    static Scanner scanner = new Scanner(System.in);

    public static void actionWrite() {

        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();

        Post post = PostService.write(title, content);
        System.out.println("게시글이 등록되었습니다.");
    }


}
