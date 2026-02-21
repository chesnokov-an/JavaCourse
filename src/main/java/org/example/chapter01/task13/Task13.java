package org.example.chapter01.task13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task13 {
    static void main() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 49; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> chosen = new ArrayList<>();
        Random generator = new Random();

        for (int i = 1; i <= 6; i++) {
            int index = generator.nextInt(numbers.size());
            chosen.add(numbers.remove(index));
        }

        Collections.sort(chosen);
        System.out.println(chosen);
    }
}
