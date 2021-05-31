package org.example.controller.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static double nextDouble() {
        double input = SCANNER.nextDouble();
        SCANNER.nextLine();
        return input;
    }
}
