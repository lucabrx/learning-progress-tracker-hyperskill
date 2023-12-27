package org.learningProgressTracker;

import java.util.Scanner;


public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        return scanner.nextLine().trim();
    }
}

