package com.team2.app;

import com.team2.Rq;
import com.team2.context.AppContext;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final AppContext appContext;

    public App() {
        this.sc = new Scanner(System.in);
        this.appContext = new AppContext();
        this.appContext.init();
    }

    public void run() {
        System.out.println("== 게시판 프로그램 ==");
        while (true) {
            System.out.print("명령: ");
            String commandStr = sc.nextLine().trim();

            if (commandStr.equals("end")) {
                System.out.println("종료합니다.");
                break;
            }

            Rq rq = new Rq(commandStr);

            switch (rq.getCommand()) {
                case "write" -> appContext.getPostController().write();
                case "list" -> appContext.getPostController().list();
                case "detail" -> appContext.getPostController().detail(rq);
                case "delete" -> appContext.getPostController().delete(rq);
                case "update" -> appContext.getPostController().update(rq);
                default -> System.out.println("명령어를 확인해주세요.");
            }
        }
        sc.close();
    }
}