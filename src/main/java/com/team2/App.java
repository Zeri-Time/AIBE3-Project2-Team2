package com.team2;

import com.team2.controller.PostController;
import com.team2.controller.SystemController;

import java.util.Scanner;

public class App {

    public App() {
    }

    void run() {
        while(true) {
            System.out.print("명령어: ");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            switch (cmd) {
                case "write" -> PostController.actionWrite();
                case "exit" -> {
                    SystemController.actionExit();
                    return;
                }
                case "list" -> PostController.actionList();
            }
        }
    }
}
