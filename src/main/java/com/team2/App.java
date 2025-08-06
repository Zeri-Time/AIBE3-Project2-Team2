package com.team2;

import com.team2.controller.PostController;
import com.team2.controller.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run() {
        SystemController systemController = AppContext.systemController;
        PostController postController = AppContext.postController;

        while (true) {
            System.out.print("명령어: ");
            String cmd = scanner.nextLine();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "write" -> postController.writeArticle();
                case "list" -> postController.listArticles();
                case "detail" -> postController.showDetail(rq.getParamsAsInt());
                case "update" -> postController.updateArticle(rq.getParamsAsInt());
                //case "delete" -> deleteArticle(rq.getParamsAsInt());
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}
