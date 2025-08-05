package com.team2.standart.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtil.genScanner() 테스트")
    public void t1() {
        Scanner scanner =  TestUtil.genScanner("""
                input 1
                input 2
                input 3
                """);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        String input3 = scanner.nextLine();

        assertThat(input1).isEqualTo("input 1");
        assertThat(input2).isEqualTo("input 2");
        assertThat(input3).isEqualTo("input 3");
    }

    @Test
    @DisplayName("TestUtil.setOutToByteArray() 테스트")
    public void t2() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("outputTest");

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray();

        assertThat(out).isEqualTo("outputTest");
    }
}