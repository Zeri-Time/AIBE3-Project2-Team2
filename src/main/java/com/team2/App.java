package com.team2;

import com.team2.controller.PostController;

public class App {
    public void run() {
        System.out.println("== 게시판 ==");

        PostController postController = AppContext.postController;

        while (true) {
            System.out.print("명령) ");
            String cmd = AppContext.sc.nextLine().trim();

            switch (cmd) {
                case "등록" -> postController.actionWrite();
                case "목록" -> postController.actionList();
                case "종료" -> {
                    return;
                }
                default -> System.out.println("알 수 없는 명령어입니다.");
            }
        }

    }
}
