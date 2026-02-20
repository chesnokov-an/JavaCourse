package org.example.chapter01.task10;

import java.util.Random;

public class Task10 {
    static void main() {
        Random generator = new Random();
        long num = generator.nextLong();
        System.out.println(Long.toString(num, 36));
    }
}
