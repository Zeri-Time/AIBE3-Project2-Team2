package com.team2.controller;

import com.team2.Rq;
import com.team2.domain.post.Post;
import com.team2.repository.PostRepository;
import com.team2.service.PostService;

import java.util.List;
import java.util.Scanner;

public class PostController {
    static Scanner scanner = new Scanner(System.in);

    public static void actionWrite() {

        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();

        Post post = PostService.write(title, content);
        System.out.println("=> 게시글이 등록되었습니다.");
    }


    public static void actionList() {
        List<Post> postList = PostService.getPostList();
        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        for(int i = 0; i < postList.size(); i ++) {
            Post post = postList.get(i);
            System.out.printf("%d   | %s | %s\n", post.getId(), post.getTitle(), post.getCreateDate());
        }
    }

    public static void actionDetail(Rq rq) {
        int id = rq.getParamAsInt();

        Post post = PostService.findById(id);
        System.out.println("번호: " + post.getId());
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: " + post.getContent());
        System.out.println("등록일: " + post.getCreateDate());
    }

    public static void actionUpdate(Rq rq) {
        int id = rq.getParamAsInt();

        Post post = PostService.findById(id);

        System.out.print("제목 (현재: %s): ".formatted(post.getTitle()));
        String newTitle = scanner.nextLine();
        System.out.print("내용 (현재: %s): ".formatted(post.getTitle()));
        String newContent = scanner.nextLine();

        PostService.modify(post, newTitle, newContent);
        System.out.println("=> 게시글이 수정되었습니다.");
    }
}
