package com.team2.app;

import com.team2.Rq;
import com.team2.controller.PostController;

import java.util.Scanner;

// 클래스 선언
public class App {
    private final Scanner sc;
    private final PostController postController;
//    private final List<Post> posts;
//    private int lastPostId;


    // 필드 초기화
    public App() {
        this.sc = new Scanner(System.in);
        this.postController = new PostController();
//        this.posts = new ArrayList<>();
//        this.lastPostId = 0;
    }

    public void run() {
        System.out.println("== 게시판 프로그램 ==");
        while (true) {
            System.out.print("명령: ");
            String commandStr = sc.nextLine().trim();

            if (commandStr.equals("end") || commandStr.equals("exit")) {
                System.out.println("종료합니다.");
                break;
            }

            Rq rq = new Rq(commandStr);

            switch (rq.getCommand()) {
                case "write" -> postController.write();
                case "list" -> postController.list();
                case "detail" -> postController.detail(rq);
                case "delete" -> postController.delete(rq);
                case "update" -> postController.update(rq);
                default -> System.out.println("명령어를 확인해주세요.");
            }
        }
        sc.close();
    }
}