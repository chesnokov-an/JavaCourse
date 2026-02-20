package org.example.chapter01.task09;

import java.util.Scanner;

public class Task09 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("mama".equals(str));
        System.out.println("mama" == str);
    }
}
