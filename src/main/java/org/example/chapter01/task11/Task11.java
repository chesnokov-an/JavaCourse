package org.example.chapter01.task11;

import java.util.Scanner;

public class Task11 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] symbols = str.codePoints().toArray();
        for(int symbol : symbols){
            if(symbol > 255){
                System.out.printf("symbol '%s' - U+%x%n", new String(Character.toChars(symbol)), symbol);  // 𰻞 - example
            }
        }
    }
}
