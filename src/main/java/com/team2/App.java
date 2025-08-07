package com.team2;

import com.team2.controller.PostController;
import com.team2.controller.SystemController;
import com.team2.domain.post.Post;

import java.util.Scanner;

public class App {

    public App() {
    }

    void run() {
        while(true) {
            System.out.print("명령어: ");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);
            switch (rq.getActionName()) {
                case "write" -> PostController.actionWrite();
                case "exit" -> {
                    SystemController.actionExit();
                    return;
                }
                case "list" -> PostController.actionList();
                case "detail" -> PostController.actionDetail(rq);
                case "update" -> PostController.actionUpdate(rq);
                case "delete" -> PostController.actionDelete(rq);
            }
        }
    }
}
