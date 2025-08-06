package com.team2;

import com.team2.controller.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run() {
        SystemController systemController = AppContext.systemController;

        while (true) {
            System.out.print("명령어: ");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                //case "write" -> writeArticle(sc);
                //case "list" -> listArticles();
                //case "detail" -> showDetail(rq.getParamsAsInt());
               // case "update" -> updateArticle(rq.getParamsAsInt());
                //case "delete" -> deleteArticle(rq.getParamsAsInt());
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}
