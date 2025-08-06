package com.team2;

import com.team2.controller.PostController;

public class App {
    void run() {
        System.out.println("== 게시글 ==");

        PostController postController = AppContext.postController;

        while (true) {
            System.out.print("명령) ");
            String cmd = AppContext.scanner.nextLine().trim();

            switch (cmd) {
                case "등록" -> postController.actionWrite();

                default -> System.out.println("다시 입력해주십시오.");

            }
        }
    }
}