package com.team2;

import com.team2.standard.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        Scanner scanner = TestUtil.genScanner(input);

        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        AppContext.renew(scanner);
        new App().run();

        return output.toString();
    }
}
