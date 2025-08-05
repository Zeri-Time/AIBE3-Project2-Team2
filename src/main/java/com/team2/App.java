package com.team2;

import com.team2.controller.PostController;
import com.team2.global.Rq;

import java.util.Scanner;

public class App {

    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run() {
        PostController postController = AppContext.postController;

        while(true) {
            System.out.print("명렁어: ");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);

            switch(rq.getActionName()) {
                case "write" -> postController.actionWrite();
                case "list" -> postController.actionList();
                case "detail" -> postController.actionDetail(rq.getParamAsInt("id", -1));
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("명령어를 다시 입력 해 주세요.");
            }
        }
    }
}
