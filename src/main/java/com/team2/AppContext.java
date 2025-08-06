package com.team2;

import com.team2.controller.SystemController;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static SystemController systemController;

    public static void renew (Scanner _scanner) {
        scanner = _scanner;
        systemController = new SystemController();

    }

    public static void renew () {
        renew(new Scanner(System.in));
    }
}
