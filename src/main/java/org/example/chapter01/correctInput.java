package org.example.chapter01;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class correctInput {
    public static int readInt(Scanner scanner, String message) {
        int num;
        while (true) {
            System.out.print(message);
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("End of input");
            }
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Not a number entered");
                scanner.next();
            }
        }
        return num;
    }
}